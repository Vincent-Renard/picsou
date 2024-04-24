package com.ekwateur.picsou.pricing;

import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.customer.ProfessionalCustomer;
import com.ekwateur.picsou.model.pricing.PricingPolicy;

import java.math.BigDecimal;

public class BigProfessionalCustomerPricingStrategy extends ProfessionalCustomerPricingStrategy {
    public BigProfessionalCustomerPricingStrategy() {
        super(new PricingPolicy(BigDecimal.valueOf(0.110), BigDecimal.valueOf(0.123)));
    }

    @Override
    public boolean supports(Customer customer) {
        return customer instanceof ProfessionalCustomer professionalCustomer &&
                professionalCustomer.isRevenuesOverThreshold(getModestBigThreshold());
    }
}
