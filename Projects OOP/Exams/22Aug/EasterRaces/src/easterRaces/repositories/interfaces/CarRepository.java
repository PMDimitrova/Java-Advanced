package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CarRepository implements Repository<Car> {

    private List<Car> cars;

    public CarRepository() {
        this.cars = new LinkedList<>();
    }

    @Override
    public Car getByName(String name) {
        Car output = null;
        for (Car car :cars) {
            if (car.getModel().equals(name)){
                output = car;
            }
        }
        return output;
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(cars);
    }

    @Override
    public void add(Car model) {
        cars.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return cars.remove(model);
    }
}
