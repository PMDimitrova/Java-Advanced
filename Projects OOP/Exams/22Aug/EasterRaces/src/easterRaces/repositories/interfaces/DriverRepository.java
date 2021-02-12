package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;

import java.util.*;

public class DriverRepository implements Repository <Driver> {
    private List<Driver> drivers;

    public DriverRepository(){
        this.drivers = new LinkedList<>();
    }

    @Override
    public Driver getByName(String name) {
       Driver output = null;
        for (Driver dri :drivers) {
            if (dri.getName().equals(name)){
                output = dri;
            }
        }
        return output;
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void add(Driver model) {
        drivers.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return this.drivers.remove(model);
    }
}
