package VehiclesNEW;

public class Bus extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITION_CONSUMPTION = 1.4;

    protected Bus(double quantityFuel, double consumptionOnFuel, double tankCapacity) {
        super(quantityFuel, (consumptionOnFuel), tankCapacity);
    }

    @Override
    public String drive(double kms){
        super.increaseConsumption(AIR_CONDITIONER_ADDITION_CONSUMPTION);
        return super.drive(kms);
    }
    public void driveEmpty(double kms){
        super.drive(kms);
    }

}
