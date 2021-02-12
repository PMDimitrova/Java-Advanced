package CounterStriker.models.guns;

public class Rifle extends GunImpl implements Gun{
    public Rifle(String name, int bulletsCount) {
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
        if (super.getBulletsCount()<10){
            return 0;
        }
        return 10;
    }       //DONE
}
