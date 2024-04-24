package com.ekwateur.picsou.pricing;

import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.customer.IndividualCustomer;
import com.ekwateur.picsou.model.pricing.PricingPolicy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class IndividualCustomerPricingStrategy extends CustomerPricingStrategy {
    private static final PricingPolicy PRICING_POLICY = new PricingPolicy(BigDecimal.valueOf(0.133), BigDecimal.valueOf(0.108));

    public IndividualCustomerPricingStrategy() {
        super(PRICING_POLICY);
    }

    @Override
    public boolean supports(Customer customer) {
        return customer instanceof IndividualCustomer;
    }
}
