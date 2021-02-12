package Restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {
    private double calories;
    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    @Override
    public void setPrice(BigDecimal price) {
        super.setPrice(price);
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }
}
