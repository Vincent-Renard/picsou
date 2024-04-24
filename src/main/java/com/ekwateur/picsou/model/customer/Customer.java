package com.ekwateur.picsou.model.customer;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@EqualsAndHashCode
public abstract class Customer {
    String customerRef; //12 char
    boolean hasGasContract, hasElectricityContract;
}