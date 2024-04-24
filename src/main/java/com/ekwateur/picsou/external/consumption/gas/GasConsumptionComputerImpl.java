package com.ekwateur.picsou.external.consumption.gas;

import java.util.Random;

public class GasConsumptionComputerImpl implements GasConsumptionComputer {

    private static final double GAS_KWH_UPPER_BOUND = 1800.0;
    private static final double GAS_KWH_LOWER_BOUND = 250.0;
    private final Random random = new Random();

    @Override
    public double computeGasUsedKWH() {
        return random.nextDouble(GAS_KWH_LOWER_BOUND, GAS_KWH_UPPER_BOUND);
    }

}
