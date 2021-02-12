package robotService.models.robots.interfaces;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot {
    private String name;
    private int happiness;
    private int energy;
    private int procedureTime;
    private String owner;
    private boolean isBought;
    private boolean isRepaired;

    protected BaseRobot(String name, int happiness, int energy, int procedureTime) {
        this.name = name;
        setHappiness(happiness);
        setEnergy(energy);
        setProcedureTime(procedureTime);
        this.owner = "Service";
        isBought = false;
        isRepaired = false;
    }

    @Override
    public String getName() {
        return this.name;
    }       //DONE

    @Override
    public int getHappiness() {
        return this.happiness;
    }//DONE

    @Override
    public void setHappiness(int happiness) {
        if (happiness < 0 || happiness > 100) {
            throw new IllegalArgumentException(INVALID_HAPPINESS);
        }
        this.happiness = happiness;
    }   //DONE

    @Override
    public int getEnergy() {
        return this.energy;
    }   //DONE

    @Override
    public void setEnergy(int energy) {
        if (energy < 0 || energy > 100) {
            throw new IllegalArgumentException(INVALID_ENERGY);
        }
        this.energy = energy;
    }   //DONE

    @Override
    public int getProcedureTime() {
        return this.procedureTime;
    }      //DONE

    @Override
    public void setProcedureTime(int procedureTime) {
        this.procedureTime -=procedureTime;
    }   //DONE

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void setBought(boolean bought) {
        this.isBought = bought;
    }

    @Override
    public boolean isRepaired() {
        return this.isRepaired;
    }

    @Override
    public void setRepaired(boolean repaired) {
        this.isRepaired = repaired;
    }

    @Override
    public String toString() {
        return "BaseRobot{}"; //-----------------
    }
}
