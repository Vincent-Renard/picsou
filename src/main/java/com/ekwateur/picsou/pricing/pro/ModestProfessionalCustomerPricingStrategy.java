package com.ekwateur.picsou.pricing.pro;

import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.customer.ProfessionalCustomer;
import com.ekwateur.picsou.model.pricing.PricingPolicy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ModestProfessionalCustomerPricingStrategy extends ProfessionalCustomerPricingStrategy {
    private static final PricingPolicy PRICING_POLICY = new PricingPolicy(BigDecimal.valueOf(0.112), BigDecimal.valueOf(0.117));

    public ModestProfessionalCustomerPricingStrategy() {
        super(PRICING_POLICY);
    }

    @Override
    public boolean supports(Customer customer) {
        return customer instanceof ProfessionalCustomer professionalCustomer
                && !professionalCustomer.isRevenuesOverThreshold(getModestBigThreshold());
    }
}
