package bakery.entities.drinks.interfaces;

public class Water extends BaseDrink{
    private static final double WaterPrice = 1.50;
    public Water(String name, int portion, double price, String brand) {
        super(name, portion, WaterPrice, brand);
    }
}
