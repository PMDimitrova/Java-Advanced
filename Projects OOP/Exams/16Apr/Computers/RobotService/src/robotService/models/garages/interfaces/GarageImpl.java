package robotService.models.garages.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;
import java.util.Map;

import static robotService.common.ExceptionMessages.*;

public class GarageImpl implements Garage {
    private final static int GARAGE_CAPACITY = 10;

    private int capacity;
    private Map<String, Robot> robots; // String is Robot name

    public GarageImpl() {
        capacity = GARAGE_CAPACITY;
        robots = new LinkedHashMap<>();
    } //DONE

    @Override
    public Map<String, Robot> getRobots() {
        return this.robots;
    }       //DONE

    @Override
    public void manufacture(Robot robot) {
        if (robots.size() == capacity){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        if (robots.containsKey(robot.getName())){
            throw new IllegalArgumentException(String.format(EXISTING_ROBOT, robot.getName()));
        }

        robots.put(robot.getName(), robot);
    }   //DONE

    @Override
    public void sell(String robotName, String ownerName) {
        Robot robot;
        try {
            robot = robots.get(robotName);
        } catch (Exception exception) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
        robot.setOwner(ownerName);
        robot.setBought(true);
        robots.remove(robotName);
    }   //DONE
}
