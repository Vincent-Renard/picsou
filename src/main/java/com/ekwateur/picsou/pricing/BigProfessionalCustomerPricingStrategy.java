package com.ekwateur.picsou.pricing;

import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.pricing.PricingPolicy;

public class BigProfessionalCustomerPricingStrategy extends ProfessionalCustomerPricingStrategy {
    public BigProfessionalCustomerPricingStrategy(PricingPolicy pricingPolicy) {
        super(pricingPolicy);
    }

    @Override
    public boolean supports(Customer customer) {
        return false;
    }
}
