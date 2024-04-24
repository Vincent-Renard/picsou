package com.ekwateur.picsou.pricing;

import com.ekwateur.picsou.model.pricing.PricingPolicy;

public abstract class ProfessionalCustomerPricingStrategy extends CustomerPricingStrategy {

    public ProfessionalCustomerPricingStrategy(PricingPolicy pricingPolicy) {
        super(pricingPolicy);
    }
}
