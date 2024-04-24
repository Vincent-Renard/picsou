package com.ekwateur.picsou.model.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class ProfessionalCustomer extends Customer {
    @Column(nullable = false, length = 14)
    String siretNumber; // s = 14

    @Column(nullable = false)
    String businessName;

    @Column(nullable = false)
    BigInteger revenues;

    public boolean isRevenuesOverThreshold(BigInteger threshold) {
        return revenues.compareTo(threshold) > 0;
    }
}
