package com.ekwateur.picsou.pricing;

import com.ekwateur.picsou.model.pricing.PricingPolicy;
import lombok.Getter;

import java.math.BigInteger;

@Getter
public abstract class ProfessionalCustomerPricingStrategy extends CustomerPricingStrategy {
    private static final int REVENUE_MODEST_BIG_THRESHOLD = 1000000;

    private final BigInteger modestBigThreshold = BigInteger.valueOf(REVENUE_MODEST_BIG_THRESHOLD);

    public ProfessionalCustomerPricingStrategy(PricingPolicy pricingPolicy) {
        super(pricingPolicy);
    }
}
