package com.ekwateur.picsou.model.invoice.invoice;


import lombok.Builder;

import java.math.BigDecimal;


/**
 * Represents an energy customer bill
 */
@Builder(builderMethodName = "with")
public class Invoice {

    String customerRef;
    String month;

    double electricityConsumptionKWH;
    double gasConsumptionKWH;

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
        gasBill = BigDecimal.valueOf(gasConsumptionKWH).multiply(gasPrice);
        return gasBill;
    }

    public BigDecimal computeElectricityBill() {
        electricityBill = BigDecimal.valueOf(electricityConsumptionKWH).multiply(electricityPrice);
        return electricityBill;
    }
}