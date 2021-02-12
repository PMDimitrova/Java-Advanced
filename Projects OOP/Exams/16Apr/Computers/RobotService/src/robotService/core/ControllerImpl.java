package robotService.core;

import robotService.core.interfaces.Controller;
import robotService.models.garages.interfaces.Garage;
import robotService.models.procedures.interfaces.BaseProcedure;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.procedures.interfaces.Repair;
import robotService.models.robots.interfaces.Cleaner;
import robotService.models.robots.interfaces.Housekeeper;
import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.*;
import static robotService.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Garage garage;
    private Procedure charge;
    private Procedure repair;
    private Procedure work;

    public ControllerImpl() {
        //should not get any arguments
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {
        Robot robot;
        switch (robotType) {
            case "Housekeeper":
                robot = new Housekeeper(name, happiness, energy, procedureTime);
                break;
            case "Cleaner":
                robot = new Cleaner(name, happiness, energy, procedureTime);
                break;
            default: throw new IllegalArgumentException(String.format(INVALID_ROBOT_TYPE, robotType));
        }
        return String.format(ROBOT_MANUFACTURED, name);
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        checkIfRobotIsInGarage(robotName);
        Robot robot = this.garage.getRobots().get(robotName);
        BaseProcedure baseProcedure = new Repair();
        baseProcedure.doService(robot, procedureTime);
        return null;
    }

    @Override
    public String work(String robotName, int procedureTime) {
        checkIfRobotIsInGarage(robotName);
        return null;
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        checkIfRobotIsInGarage(robotName);
        return null;
    }

    @Override
    public String sell(String robotName, String ownerName) {
        checkIfRobotIsInGarage(robotName);
        return null;
    }

    @Override
    public String history(String procedureType) {
        return null;
    }

    private void checkIfRobotIsInGarage(String robotName) {
        if (!this.garage.getRobots().containsKey(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
    }   //DONE
}
