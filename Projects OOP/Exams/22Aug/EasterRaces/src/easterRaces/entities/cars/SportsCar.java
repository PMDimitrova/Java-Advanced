package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CM_SPORT = 3000;

    public SportsCar(String model, int horsePower, double cubicCentimeters) {
        super(model, horsePower, DEFAULT_CUBIC_CM_SPORT);
        if (horsePower<250 || horsePower>450){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }

    }
}
