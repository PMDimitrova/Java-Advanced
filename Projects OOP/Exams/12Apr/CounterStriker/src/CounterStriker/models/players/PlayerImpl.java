package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        this.isAlive = true;
        setGun(gun);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }       //DONE

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }       //DONE

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }       //DONE

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }       //DONE

    @Override
    public String getUsername() {
        return this.username;
    }       //DONE

    @Override
    public int getHealth() {
        return this.health;
    }       //DONE

    @Override
    public int getArmor() {
        return this.armor;
    }       //DONE

    @Override
    public Gun getGun() {
        return this.gun;
    }       //DONE

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }        //DONE

    @Override
    public void takeDamage(int points) {
        if (this.armor > 0) {
            this.armor -= points;
        }
        int pointsToTransfer = 0;
        if (this.armor < 0) {
            pointsToTransfer = Math.abs(this.armor);
        }
        if (pointsToTransfer > 0) {
            this.health -= pointsToTransfer;
            if (this.health < 0) {
                this.isAlive = false;
            }
        }
    }        //DONE

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getUsername() + System.lineSeparator());
        builder.append("--Health");

        return builder.toString().trim();
    }
}
