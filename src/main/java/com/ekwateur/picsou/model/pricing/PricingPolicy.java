package com.ekwateur.picsou.model.pricing;

import java.math.BigDecimal;

public record PricingPolicy(BigDecimal electricityPrice, BigDecimal gasPrice) {
}
