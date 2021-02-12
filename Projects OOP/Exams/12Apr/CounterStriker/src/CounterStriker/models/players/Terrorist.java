package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public class Terrorist extends PlayerImpl implements Player{
    public Terrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }       //DONE

    @Override
    public int getHealth() {
        return super.getHealth();
    }       //DONE

    @Override
    public int getArmor() {
        return super.getArmor();
    }       //DONE

    @Override
    public Gun getGun() {
        return super.getGun();
    }       //DONE

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }       //DONE

    @Override
    public void takeDamage(int points) {      //DOne
        super.takeDamage(points);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + super.toString();
    }
}
