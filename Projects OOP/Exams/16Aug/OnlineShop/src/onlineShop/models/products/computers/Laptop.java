package onlineShop.models.products.computers;

public class Laptop extends BaseComputer{

    public static final int DEFAULT_PERFORMANCE_LAPTOP= 10;
    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, DEFAULT_PERFORMANCE_LAPTOP);
    }
}
