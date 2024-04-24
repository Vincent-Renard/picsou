package com.ekwateur.picsou.model.customer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ProfessionalCustomer extends Customer {
    String siretNumber; // s = 14
    String businessName;
    BigInteger revenues;

    boolean isRevenuesOverThreshold(BigInteger threshold) {
        return revenues.compareTo(threshold) > 0;
    }
}
