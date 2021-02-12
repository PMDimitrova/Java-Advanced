package vehicle;

public class Vehicle {
    public final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public void drive(double kilometers) {
        double consumedFuel = kilometers * this.fuelConsumption;
        if (this.fuel>=consumedFuel){
            this.fuel -= consumedFuel;
        }
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
