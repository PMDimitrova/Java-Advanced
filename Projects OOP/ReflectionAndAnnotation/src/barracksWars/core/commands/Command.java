package c;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected Repository getRepository(){
        return this.repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }

    public String[] getData() {
        return data;
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        return null;
    }
}
