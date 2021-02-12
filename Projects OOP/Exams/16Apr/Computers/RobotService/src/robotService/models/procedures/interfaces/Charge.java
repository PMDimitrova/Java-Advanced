package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

public class Charge extends BaseProcedure implements Procedure {
    @Override
    public String history() {
        return super.history(); //DONE maybe
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);

    }
}
