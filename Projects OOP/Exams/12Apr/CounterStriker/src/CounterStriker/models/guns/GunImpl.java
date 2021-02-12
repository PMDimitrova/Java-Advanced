package CounterStriker.models.guns;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class GunImpl implements Gun {
    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }       //DONE

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_GUN_NAME);
        }
        this.name = name;
    }       //DONE

    private void setBulletsCount(int bulletsCount) {
        if (bulletsCount <= 0){
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
            this.bulletsCount = bulletsCount;
    }       //DONE

    @Override
    public String getName() {
        return this.name;
    }      //DONE

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }      //DONE

    @Override
    public int fire() {
        return 1;
    } //DONE   maybe's broken
}
