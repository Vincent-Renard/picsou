package com.ekwateur.picsou.model.customer.invoice;


import lombok.Builder;

import java.math.BigDecimal;


/**
 * Represents an energy customer bill
 */
@Builder(builderMethodName = "with")
public class Invoice {

    String customerRef;
    String month;

    double electricityConsumption;
    double gasConsumption;

    @Builder.Default
    BigDecimal gasPrice = BigDecimal.ZERO;
    @Builder.Default
    BigDecimal electricityPrice = BigDecimal.ZERO;

    BigDecimal gasBill, electricityBill, total;

    public BigDecimal computeTotal() {
        total = computeGasBill().add(computeElectricityBill());
        return total;
    }

    public BigDecimal computeGasBill() {
        gasBill = BigDecimal.valueOf(gasConsumption).multiply(gasPrice);
        return gasBill;
    }

    public BigDecimal computeElectricityBill() {
        electricityBill = BigDecimal.valueOf(electricityConsumption).multiply(electricityPrice);
        return electricityBill;
    }
}