package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public abstract class BaseProcedure implements Procedure {
    protected Map<String, List<Robot>> robots;

    protected BaseProcedure() {
//        robots = new LinkedHashMap<>();
    }   //Done

    @Override
    public String history() {
    //        StringBuilder builder = new StringBuilder();
    //        for (Map.Entry<String, List<Robot>> entry : robots.entrySet()) {
    //            builder.append(entry.getKey()); //"{procedureType}"
    //            builder.append(System.lineSeparator());
    //            for (List<Robot> robotEntry : robots.values()) {
    //                builder.append(robotEntry.toString());
    //                builder.append(System.lineSeparator());
    //            }
    //        }return builder.toString().trim()

        return "History for BaseProcedure is empty";
    }   //DONE maybe

    @Override
    public void doService(Robot robot, int procedureTime) {
//        int robotProcedureTime = robot.getProcedureTime();
//
//        if (robotProcedureTime < procedureTime) {
//            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
//        }
//
//        robot.setProcedureTime(procedureTime);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() ; //----------------
    }
}
