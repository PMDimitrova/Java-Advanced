package robotService.models.robots.interfaces;

public class Housekeeper extends BaseRobot implements Robot{
    public Housekeeper(String name, int happiness, int energy, int procedureTime) {
        super(name, happiness, energy, procedureTime);
    }

    @Override
    public String getName() {
        return super.getName();
    }       //DONE

    @Override
    public int getHappiness() {
        return super.getHappiness();
    }       //DONE

    @Override
    public void setHappiness(int happiness) {
        super.setHappiness(happiness);
    }       //DONE

    @Override
    public int getEnergy() {
        return super.getEnergy();
    }       //DONE

    @Override
    public void setEnergy(int energy) {
        super.setEnergy(energy);
    }       //DONE

    @Override
    public int getProcedureTime() {
        return super.getProcedureTime();
    }       //DONE

    @Override
    public void setProcedureTime(int procedureTime) {
        super.setProcedureTime(procedureTime);
    }       //DONE

    @Override
    public void setOwner(String owner) {
        super.setOwner(owner);
    }       //DONE

    @Override
    public void setBought(boolean bought) {
        super.setBought(bought);
    }       //DONE

    @Override
    public boolean isRepaired() {
        return super.isRepaired();
    }       //DONE

    @Override
    public void setRepaired(boolean repaired) {
        super.setRepaired(repaired);
    }       //DONE

    @Override
    public String toString() {
        return super.toString() + String.format(" Robot type: %s - " +
                "%s - Happiness: %d - Energy: %d",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getHappiness(),
                this.getEnergy());
    }
}
