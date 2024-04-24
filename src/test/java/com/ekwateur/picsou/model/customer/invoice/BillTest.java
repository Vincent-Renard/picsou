package com.ekwateur.picsou.model.customer.invoice;

import com.ekwateur.picsou.model.invoice.Bill;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class BillTest {

    private static final double ELECTRICITY_CONSUMPTION_KWH = 390.0;
    private static final double GAS_CONSUMPTION_KWH = 958.0;
    private static final BigDecimal ELECTRICITY_PRICE_PER_KWH = BigDecimal.valueOf(0.123);
    private static final BigDecimal GAS_PRICE_PER_KWH = BigDecimal.valueOf(0.987);

    @Test
    void totalComputing() {

        var invoice = Bill.with().customerRef("TEK123456789")
                .electricityConsumptionKWH(ELECTRICITY_CONSUMPTION_KWH)
                .gasConsumptionKWH(GAS_CONSUMPTION_KWH).gasPrice(GAS_PRICE_PER_KWH).electricityPrice(ELECTRICITY_PRICE_PER_KWH).build();

        Assertions.assertThat(invoice.computeElectricityBill()).isEqualByComparingTo(BigDecimal.valueOf(ELECTRICITY_CONSUMPTION_KWH).multiply(ELECTRICITY_PRICE_PER_KWH));
        Assertions.assertThat(invoice.computeGasBill()).isEqualByComparingTo(BigDecimal.valueOf(GAS_CONSUMPTION_KWH).multiply(GAS_PRICE_PER_KWH));

        Assertions.assertThat(invoice.computeTotal())
                .isEqualByComparingTo(BigDecimal.valueOf(ELECTRICITY_CONSUMPTION_KWH).multiply(ELECTRICITY_PRICE_PER_KWH).add(BigDecimal.valueOf(GAS_CONSUMPTION_KWH).multiply(GAS_PRICE_PER_KWH)));


    }

    @Test
    void totalComputing_onlyElectricity() {
        final double elecConsumption = 298.12;
        final double gasConsumption = 0;

        final var elecPrice = BigDecimal.valueOf(0.123);
        final var gasPrice = BigDecimal.valueOf(0.987);
        var invoice = Bill.with().customerRef("TEK123456789")
                .electricityConsumptionKWH(elecConsumption)
                .gasConsumptionKWH(gasConsumption).gasPrice(gasPrice).electricityPrice(elecPrice).build();

        Assertions.assertThat(invoice.computeElectricityBill()).isEqualByComparingTo(BigDecimal.valueOf(elecConsumption).multiply(elecPrice));
        Assertions.assertThat(invoice.computeTotal())
                .isEqualByComparingTo(invoice.computeElectricityBill());
        Assertions.assertThat(invoice.computeGasBill())
                .isZero();
    }

    @Test
    void electricityInvoiceComputing() {


        var invoice = Bill.with().customerRef("TEK123456789")
                .electricityConsumptionKWH(ELECTRICITY_CONSUMPTION_KWH).electricityPrice(ELECTRICITY_PRICE_PER_KWH).build();

        Assertions.assertThat(invoice.computeElectricityBill())
                .isEqualByComparingTo(BigDecimal.valueOf(ELECTRICITY_CONSUMPTION_KWH)
                        .multiply(ELECTRICITY_PRICE_PER_KWH));
        Assertions.assertThat(invoice.computeTotal())
                .isEqualByComparingTo(invoice.computeElectricityBill());

    }

    @Test
    void gasInvoiceComputing() {

        var invoice = Bill.with().customerRef("TEK123456789")
                .gasConsumptionKWH(GAS_CONSUMPTION_KWH).gasPrice(GAS_PRICE_PER_KWH).build();

        Assertions.assertThat(invoice.computeGasBill())
                .isEqualByComparingTo(BigDecimal.valueOf(GAS_CONSUMPTION_KWH)
                        .multiply(GAS_PRICE_PER_KWH));

        Assertions.assertThat(invoice.computeTotal())
                .isEqualByComparingTo(invoice.computeGasBill());
    }
}