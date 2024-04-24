package com.ekwateur.picsou.model.customer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class IndividualCustomer extends Customer {

    String firstname;
    String lastname;
    Civility civility;
}