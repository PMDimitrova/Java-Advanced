package VehiclesNEW;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITION_CONSUMPTION = 1.6;

    protected Truck(double quantityFuel, double consumptionOnFuel, double tankCapacity) {
        super(quantityFuel, (consumptionOnFuel +AIR_CONDITIONER_ADDITION_CONSUMPTION), tankCapacity);
    }

    @Override
    protected String refuel(double litres) {
        super.refuel(litres * 0.95);
        return null;                                //todo correct return type
    }

}
