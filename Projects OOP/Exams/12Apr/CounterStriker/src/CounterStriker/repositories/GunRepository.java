package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.*;

public class GunRepository implements Repository{
    private List<Gun> guns;

    public GunRepository(){
        this.guns = new LinkedList<>();
    }       //DONE

    @Override
    public List<Gun> getModels() {
        return this.guns;
    }       //DONE

    @Override
    public void add(Object model) {
        Gun gun = (Gun) model;
        if (gun == null){
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        guns.add(gun);
    }       //DONE

    @Override
    public boolean remove(Object model) {
        Gun gun = (Gun) model;
        return guns.remove(gun);
    }       //DONE

    @Override
    public Object findByName(String name) {
        for (Gun gun:guns) {
            if (gun.getName().equals(name)){
                return gun;
            }
        }
        return null;
    }       //DONE
}
