package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure implements Procedure {
    @Override
    public String history() {
        return null;
    }

    @Override
    public void doService(Robot robot, int procedureTime) {

    }
}
