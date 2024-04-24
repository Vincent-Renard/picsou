package com.ekwateur.picsou.external.consumption.electricity;

/**
 * Fake Linky consumption remote connector
 */
public interface ElectricityConsumptionComputer {
    double computeElectricityUsedKWH(String month, String customerRef);
}
