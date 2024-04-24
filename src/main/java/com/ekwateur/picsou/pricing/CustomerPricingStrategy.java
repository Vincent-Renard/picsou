package com.ekwateur.picsou.pricing;

import com.ekwateur.picsou.model.customer.Customer;
import com.ekwateur.picsou.model.pricing.PricingPolicy;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.plugin.core.Plugin;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter
public abstract class CustomerPricingStrategy implements Plugin<Customer> {
    PricingPolicy pricingPolicy;
}