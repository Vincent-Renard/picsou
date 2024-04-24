package com.ekwateur.picsou.pricing.pro;

import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.customer.ProfessionalCustomer;
import com.ekwateur.picsou.model.pricing.PricingPolicy;

import java.math.BigDecimal;

public class ModestProfessionalCustomerPricingStrategy extends ProfessionalCustomerPricingStrategy {
    public ModestProfessionalCustomerPricingStrategy() {
        super(new PricingPolicy(BigDecimal.valueOf(0.112), BigDecimal.valueOf(0.117)));
    }

    @Override
    public boolean supports(Customer customer) {
        return customer instanceof ProfessionalCustomer professionalCustomer
                && !professionalCustomer.isRevenuesOverThreshold(getModestBigThreshold());
    }
}
