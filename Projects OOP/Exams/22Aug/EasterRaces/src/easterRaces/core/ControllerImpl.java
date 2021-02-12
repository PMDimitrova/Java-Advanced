package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;
    //Controller controller = new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);
    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;

    }

    @Override
    public String createDriver(String driver) {
        Driver driverNew = new DriverImpl(driver);
        if (driverRepository.getAll().contains(driverNew)) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }
        driverRepository.add(driverNew);
        return String.format(DRIVER_CREATED, driver);
    }// DONE

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        switch (type) {
            case "MuscleCar":
                car = new MuscleCar(model, horsePower, 0);
                break;
            case "SportsCar":
                car = new SportsCar(model, horsePower, 0);
                break;
        }
        if (carRepository.getAll().contains(car)) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        carRepository.add(car);
        return String.format(CAR_CREATED, type+"Car", model);
    }// DONE

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = checkIfDriverExists(driverName);

        Car car = checkIfCarExists(carModel);

        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }// DONE

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = checkIfRaceExists(raceName);

        Driver driver = checkIfDriverExists(driverName);

        race.addDriver(driver);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }// DONE

    @Override
    public String startRace(String raceName) {
        Race race = checkIfRaceExists(raceName);
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> driverList = (List<Driver>) race.getDrivers();
        int currentLaps = race.getLaps();

//        List<Driver> reversedOrderDrivers = driverList.stream()
//                .sorted(driver ->{
//                    driver.getCar().calculateRacePoints()
//                    Comparator.comparing((driver.getCar()::calculateRacePoints).reversed())})
//                    .collect(Collectors.toList());
        Map<Double, Driver> winners = new TreeMap<>(Collections.reverseOrder()); //todo check here for the reverse order map

        for (Driver driver : driverList) {
            winners.put(driver.getCar().calculateRacePoints(currentLaps), driver);
        }
        ArrayList<String> winnersOutput = new ArrayList<>();

        for (Map.Entry<Double, Driver> winner : winners.entrySet()) {
            winnersOutput.add(winner.getValue().getName());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= winnersOutput.size(); i++) {
            builder.append("Driver ");
            builder.append(winnersOutput.get(i));
            if (i == 1) {
                builder.append(" wins ");
            }else if (i == 2){
                builder.append(" is second in ");
            }else if (i == 3){
                builder.append(" is third in ");
            }
            builder.append(raceName);
            builder.append(" race.");
            builder.append(System.lineSeparator());
        }
        raceRepository.remove(race);
        return builder.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = null;
        for (Race race1 : raceRepository.getAll()) {
            if (race1.getName().equals(name)) {
                race = race1;
            }
        }
        if (!(race == null)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        race = new RaceImpl(name, laps);
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }

    private Car checkIfCarExists(String carModel) {
        Car car = null;
        for (Car carr : carRepository.getAll()) {
            if (carr.getModel().equals(carModel)) {
                car = carr;
            }
        }
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        return car;
    }

    private Driver checkIfDriverExists(String driverName) {
        Driver driver = null;
        for (Driver dri : driverRepository.getAll()) {
            if (dri.getName().equals(driverName)) {
                driver = dri;
            }
        }
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        return driver;
    }

    private Race checkIfRaceExists(String raceName) {
        Race race = null;
        for (Race race1 : raceRepository.getAll()) {
            if (race1.getName().equals(raceName)) {
                race = race1;
            }
        }
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        return race;

    }
}
