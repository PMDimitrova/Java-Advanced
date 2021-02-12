package VehiclesNEW;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double quantityFuel;
    private double consumptionOnFuel;
    private double tankCapacity;

    protected Vehicle(double quantityFuel, double consumptionOnFuel, double tankCapacity) {
        this.setFuelQuantity(quantityFuel);
        this.consumptionOnFuel = consumptionOnFuel;
        this.tankCapacity = tankCapacity;
    }

    public Vehicle(){}

    protected String drive(double km) {
        double fuelNeeded = km * this.getConsumptionOnFuel();
        double currentFuelQuantity = this.getQuantityFuel();
        if (fuelNeeded < currentFuelQuantity) {
            this.setFuelQuantity(currentFuelQuantity - fuelNeeded);
            return this.getClass().getSimpleName() + " travelled " + new DecimalFormat("#.##").format(km) + " km";
        } else {
            return this.getClass().getSimpleName() + " needs refueling";
        }
    }
    protected String refuel(double litres){
        double freeSpaceInTank = this.tankCapacity - this.quantityFuel;
        if (litres>freeSpaceInTank){
            return "Cannot fit fuel in tank";
        }else{
            this.setFuelQuantity(this.quantityFuel +=litres);
            return "";                              //maybe's wrong
        }
    }

    protected double getQuantityFuel() {
        return quantityFuel;
    }

    protected double getConsumptionOnFuel() {
        return consumptionOnFuel;
    }

    protected void setFuelQuantity(double quantityFuel) {
        if (quantityFuel<0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.quantityFuel = quantityFuel;
    }

    protected void increaseConsumption(double increase) {
        this.consumptionOnFuel += increase;
    }

    @Override
    public String toString() {
        return String.format(this.getClass().getSimpleName() + ": %.2f", this.getQuantityFuel());
    }
}
