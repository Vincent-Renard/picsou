package com.ekwateur.picsou.pricing.pro;

import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.customer.ProfessionalCustomer;
import com.ekwateur.picsou.model.pricing.PricingPolicy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigProfessionalCustomerPricingStrategy extends ProfessionalCustomerPricingStrategy {
    private static final PricingPolicy PRICING_POLICY = new PricingPolicy(BigDecimal.valueOf(0.110), BigDecimal.valueOf(0.123));

    public BigProfessionalCustomerPricingStrategy() {
        super(new PricingPolicy(BigDecimal.valueOf(0.110), BigDecimal.valueOf(0.123)));
    }

    @Override
    public boolean supports(Customer customer) {
        return customer instanceof ProfessionalCustomer professionalCustomer &&
                professionalCustomer.isRevenuesOverThreshold(getModestBigThreshold());
    }
}
