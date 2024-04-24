package com.ekwateur.picsou.services;

import com.ekwateur.picsou.external.consumption.electricity.ElectricityConsumptionComputer;
import com.ekwateur.picsou.external.consumption.gas.GasConsumptionComputer;
import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.invoice.Bill;
import com.ekwateur.picsou.pricing.CustomerPricingStrategy;
import com.ekwateur.picsou.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;
import org.springframework.stereotype.Service;

@Service
@EnablePluginRegistries(CustomerPricingStrategy.class)
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {

    private final ElectricityConsumptionComputer electricityConsumptionComputer;
    private final GasConsumptionComputer gasConsumptionComputer;
    private final PluginRegistry<CustomerPricingStrategy, Customer> pricingStrategies;

    private final CustomerRepository customerRepository;

    @Override
    public Bill generateBill(String month, String customerRef) {
        var customer = customerRepository.findById(customerRef).orElseThrow();
        var pricingPolicy = pricingStrategies.getRequiredPluginFor(customer).getPricingPolicy();
        var invoiceBuilder = Bill.with().customerRef(customer.getCustomerRef()).month(month);
        if (customer.hasGasContract()) {
            invoiceBuilder
                    .gasPrice(pricingPolicy.gasPrice())
                    .gasConsumptionKWH(gasConsumptionComputer.computeGasUsedKWH(month, customer.getCustomerRef()));
        }
        if (customer.hasElectricityContract()) {
            invoiceBuilder
                    .electricityPrice(pricingPolicy.electricityPrice())
                    .electricityConsumptionKWH(electricityConsumptionComputer.computeElectricityUsedKWH(month, customer.getCustomerRef()));
        }

        var invoice = invoiceBuilder.build();
        invoice.computeTotal();
        return invoice;
    }
}
