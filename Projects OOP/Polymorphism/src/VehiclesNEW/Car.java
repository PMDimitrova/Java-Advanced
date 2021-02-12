package VehiclesNEW;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITION_CONSUMPTION = 0.9;

    protected Car(double quantityFuel, double consumptionOnFuel, double tankCapacity) {
        super(quantityFuel, (consumptionOnFuel + AIR_CONDITIONER_ADDITION_CONSUMPTION), tankCapacity);
    }

}
