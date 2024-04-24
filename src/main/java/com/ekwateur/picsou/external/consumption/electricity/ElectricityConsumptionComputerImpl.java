package com.ekwateur.picsou.external.consumption.electricity;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ElectricityConsumptionComputerImpl implements ElectricityConsumptionComputer {
    private static final double ELEC_KWH_UPPER_BOUND = 650.0;
    private static final double ELEC_KWH_LOWER_BOUND = 50.0;
    private final Random random = new Random();

    @Override
    public double computeElectricityUsedKWH(String month, String customerRef) {
        return random.nextDouble(ELEC_KWH_LOWER_BOUND, ELEC_KWH_UPPER_BOUND);
    }
}
