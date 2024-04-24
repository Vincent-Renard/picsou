package com.ekwateur.picsou.external.consumption.electricity;

import java.util.Random;

public class ElectricityConsumptionComputerImpl implements ElectricityConsumptionComputer {
    private static final double ELEC_KWH_UPPER_BOUND = 650.0;
    private static final double ELEC_KWH_LOWER_BOUND = 50.0;
    private final Random random = new Random();

    @Override
    public double computeElectricityUsedKWH() {
        return random.nextDouble(ELEC_KWH_LOWER_BOUND, ELEC_KWH_UPPER_BOUND);
    }
}
