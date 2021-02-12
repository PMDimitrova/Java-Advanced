package bakery.entities.bakedFoods.interfaces;

public class Bread extends BaseFood{
    private static final double InitialBreadPortion = 20;
    public Bread(String name, double portion, double price) {
        super(name, InitialBreadPortion, price);
    }
}
