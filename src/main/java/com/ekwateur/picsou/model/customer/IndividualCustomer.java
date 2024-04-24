package com.ekwateur.picsou.model.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class IndividualCustomer extends Customer {
    @Column(nullable = false)
    String firstname;
    @Column(nullable = false)
    String lastname;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    Civility civility;
}