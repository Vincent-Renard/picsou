package com.ekwateur.picsou.services;

import com.ekwateur.picsou.external.consumption.electricity.ElectricityConsumptionComputer;
import com.ekwateur.picsou.external.consumption.gas.GasConsumptionComputer;
import com.ekwateur.picsou.model.customer.Civility;
import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.customer.IndividualCustomer;
import com.ekwateur.picsou.model.customer.ProfessionalCustomer;
import com.ekwateur.picsou.model.pricing.PricingPolicy;
import com.ekwateur.picsou.pricing.CustomerPricingStrategy;
import com.ekwateur.picsou.pricing.pro.ModestProfessionalCustomerPricingStrategy;
import com.ekwateur.picsou.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.plugin.core.PluginRegistry;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillingServiceTest {

    @Mock
    ElectricityConsumptionComputer electricityConsumptionComputerMock;
    @Mock
    GasConsumptionComputer gasConsumptionComputerMock;
    @Mock
    PluginRegistry<CustomerPricingStrategy, Customer> pricingStrategiesMock;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    BillingServiceImpl billingServiceMocked;

    @Mock
    ModestProfessionalCustomerPricingStrategy modestProPricing = new ModestProfessionalCustomerPricingStrategy();


    private ProfessionalCustomer professionalCustomer(boolean gasContract, boolean electricityContract, boolean big) {
        var professionalCustomer = new ProfessionalCustomer();
        professionalCustomer.setCustomerRef("EKW100000001");
        professionalCustomer.hasElectricityContract(electricityContract);
        professionalCustomer.hasGasContract(gasContract);
        professionalCustomer.setSiretNumber("22345678901234");
        professionalCustomer.setBusinessName("Pouic-Pouic Industries");
        professionalCustomer.setRevenues(big ? BigInteger.valueOf(2000000) : BigInteger.valueOf(1000));
        return professionalCustomer;
    }

    private IndividualCustomer individualCustomer(boolean gasContract, boolean electricityContract) {
        var individualCustomer = new IndividualCustomer();
        individualCustomer.setCustomerRef("EKW100000001");
        individualCustomer.hasElectricityContract(electricityContract);
        individualCustomer.hasGasContract(gasContract);
        individualCustomer.setFirstname("Firstname");
        individualCustomer.setCivility(Civility.Mrs);
        individualCustomer.setLastname("Lastname");
        return individualCustomer;
    }

    @Test
    void generateInvoice_ModestPro() {
        var customer = professionalCustomer(true, true, false);
        when(customerRepository.findById(anyString()))
                .thenReturn(Optional.of(customer));
        when(electricityConsumptionComputerMock.computeElectricityUsedKWH(anyString(), anyString())).thenReturn(200.0);
        when(gasConsumptionComputerMock.computeGasUsedKWH(anyString(), anyString())).thenReturn(100.0);
        when(pricingStrategiesMock.getRequiredPluginFor(customer)).thenReturn(modestProPricing);
        when(modestProPricing.getPricingPolicy()).thenReturn(new PricingPolicy(BigDecimal.ONE, BigDecimal.ONE));


        var invoice = billingServiceMocked.generateBill("OCT", "BLA");
        Assertions.assertThat(invoice.computeTotal())
                .isEqualByComparingTo(BigDecimal.valueOf(300.0));
        Assertions.assertThat(invoice.getCustomerRef()).isEqualTo(customer.getCustomerRef());
        Assertions.assertThat(invoice.getMonth()).isEqualTo("OCT");
        Assertions.assertThat(invoice.getElectricityPrice()).isEqualTo(BigDecimal.ONE);

    }
}