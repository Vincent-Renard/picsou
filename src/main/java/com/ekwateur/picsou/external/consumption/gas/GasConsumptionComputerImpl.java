package com.ekwateur.picsou.external.consumption.gas;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GasConsumptionComputerImpl implements GasConsumptionComputer {

    private static final double GAS_KWH_UPPER_BOUND = 1800.0;
    private static final double GAS_KWH_LOWER_BOUND = 250.0;
    private final Random random = new Random();

    @Override
    public double computeGasUsedKWH(String month, String customerRef) {
        return random.nextDouble(GAS_KWH_LOWER_BOUND, GAS_KWH_UPPER_BOUND);
    }

}
