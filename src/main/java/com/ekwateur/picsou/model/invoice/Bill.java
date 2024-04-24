package com.ekwateur.picsou.model.invoice;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


/**
 * Represents an energy customer bill
 */
@Builder(builderMethodName = "with")
@Getter
@Setter
public class Bill {

    String customerRef;
    String month;

    double electricityConsumptionKWH;
    double gasConsumptionKWH;

    @Builder.Default
    BigDecimal gasPrice = BigDecimal.ZERO;
    @Builder.Default
    BigDecimal electricityPrice = BigDecimal.ZERO;

    BigDecimal gasSubBill, electricitySubBill, total;

    public BigDecimal computeTotal() {
        total = computeGasBill().add(computeElectricityBill());
        return total;
    }

    public BigDecimal computeGasBill() {
        gasSubBill = BigDecimal.valueOf(gasConsumptionKWH).multiply(gasPrice);
        return gasSubBill;
    }

    public BigDecimal computeElectricityBill() {
        electricitySubBill = BigDecimal.valueOf(electricityConsumptionKWH).multiply(electricityPrice);
        return electricitySubBill;
    }
}