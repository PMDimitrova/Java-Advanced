package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.racers.Race;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RaceRepository implements Repository<Race>{
    private List<Race> races;

    public RaceRepository() {
        this.races = new LinkedList<>();
    }

    @Override
    public Race getByName(String name) {
        Race output = null;
        for (Race race :races) {
            if (race.getName().equals(name)){
                output = race;
            }
        }
        return output;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(races);
    }

    @Override
    public void add(Race model) {
        races.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return races.remove(model);
    }
}
