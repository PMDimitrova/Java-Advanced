package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.BaseRobot;
import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.*;

public class Repair extends BaseProcedure implements Procedure{
    @Override
    public String history() {
        return null; //------------
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.isRepaired()){
            throw new IllegalArgumentException(String.format(ALREADY_REPAIRED, robot.getName()));
        }
        int robotCurrentHappiness = robot.getHappiness();
        robot.setHappiness(robotCurrentHappiness -5);
        robot.setRepaired(true);
        robot.setProcedureTime(procedureTime);
    }
}
