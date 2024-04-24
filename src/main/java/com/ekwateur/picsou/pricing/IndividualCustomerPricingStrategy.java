package com.ekwateur.picsou.pricing;

import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.pricing.PricingPolicy;

public class IndividualCustomerPricingStrategy extends CustomerPricingStrategy {
    public IndividualCustomerPricingStrategy(PricingPolicy pricingPolicy) {
        super(pricingPolicy);
    }

    @Override
    public boolean supports(Customer customer) {
        return false;
    }
}
