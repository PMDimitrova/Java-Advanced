package barracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int GUNNAR_HEALT = 20;
    private static final int GUNNAR_DAMAGE = 20;

    public Gunner() {
        super(GUNNAR_HEALT, GUNNAR_DAMAGE);
    }
}
