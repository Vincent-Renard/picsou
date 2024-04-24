package com.ekwateur.picsou.model.customer;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Customer {

    @Id
    @Column(length = 12, nullable = false, unique = true)
    String customerRef; //12 char

    @Accessors(fluent = true)
    boolean hasGasContract, hasElectricityContract;
}