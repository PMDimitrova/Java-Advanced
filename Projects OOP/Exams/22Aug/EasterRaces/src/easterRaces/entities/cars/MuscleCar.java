package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar{
    private static final double DEFAULT_CUBIC_CM_MUSCLE = 5000;

    public MuscleCar(String model, int horsePower, double cubicCentimeters) {
        super(model, horsePower, DEFAULT_CUBIC_CM_MUSCLE);
        if (horsePower<400 || horsePower>600){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
    }
}
