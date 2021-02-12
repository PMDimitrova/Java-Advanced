package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

import static easterRaces.common.ExceptionMessages.*;

public class DriverImpl implements Driver{
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name){
        setName(name);
        this.car = null;
        setNumberOfWins(0);
        setCanParticipate(false);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length()<5){
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }   //DONE

    public void setCar(Car car) {
        this.car = car;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;   //default, not changed
    }

    public void setCanParticipate(boolean canParticipate) {
        this.canParticipate = canParticipate;  //default, not changed
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null){
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.car = car;
        setCanParticipate(true);
    }

    @Override
    public void winRace() {
        setNumberOfWins(getNumberOfWins() + 1);
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
