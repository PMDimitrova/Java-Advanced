package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static easterRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car{
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters){
        setModel(model);
        setHorsePower(horsePower);
        setCubicCentimeters(cubicCentimeters);
    }

    @Override
    public String getModel() {
        return this.model;
    }   //DONE

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }   //DONE

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }    //DONE

    public void setModel(String model) {
        if ( model==null || model.length()<4 || model.trim().isEmpty()){
        throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
    }    //DONE

    public void setHorsePower(int horsePower) {
        try {
            this.horsePower = horsePower;
        }catch (Exception ex){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }

    }    //DONE

    public void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;

    }

    @Override
    public double calculateRacePoints(int laps) {
        return getCubicCentimeters()/getHorsePower() * laps;
    }
}
