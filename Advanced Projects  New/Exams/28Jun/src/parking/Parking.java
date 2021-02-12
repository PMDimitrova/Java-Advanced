package parking;

import javax.print.DocFlavor;
import java.util.*;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity){
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>(capacity);
    }

    public String getStatistics(){
        StringBuilder output = new StringBuilder("The cars are parked in " +this.type + ":" + System.lineSeparator());
        for (Car car:data) {
            output.append(car.toString() + System.lineSeparator());
        }

        return output.toString();
    }

    public int getCount(){
        return this.data.size();
    }

    public Car getCar(String manufacturer, String model){
        Car outputcar = new Car();

        for (Car car1: data) {
            if (car1.getManufacturer().equals(manufacturer) && car1.getModel().equals(model)){
                outputcar = car1;
            }
        }
        return outputcar.getModel() != null ? outputcar : null ; ///NOT SURE
    }

    public Car getLatestCar(){
        if (data.isEmpty()){
            return null;
        }
        Car output = new Car();
        int oldest = -1;
        for (Car car : data) {
            if (oldest < car.getYear()){
                output = car;
                oldest = car.getYear();
            }
        }
        return output;
    }

    public void add(Car car){
        if (this.data.size() < capacity){
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        for (Car car:data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }


}
