package CounterStriker.models.guns;

public class Pistol extends GunImpl implements Gun{
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public String getName() {
        return super.getName();
    }       //DONE

    @Override
    public int getBulletsCount() {
        return super.getBulletsCount();
    }       //DONE

    @Override
    public int fire() {
        if (super.getBulletsCount()<1){
            return 0;
        }
        return 1;
    }       //DONE
}
