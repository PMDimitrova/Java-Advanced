package PizzaCalories;

import java.lang.reflect.Array;
import java.util.*;

public class Topping {
    private String toppingType;
    private double weight;
    private static final Set<String> ALLOWED_TOPPINGS = Set.of("Meat", "Veggies", "Cheese", "Sauce");

    public Topping(String type, double weight) {
        setToppingType(type);
        setWeight(weight);
    }

    private void setToppingType(String type) {      //CHECKED
        if (!ALLOWED_TOPPINGS.contains(type)) {
            throw new IllegalArgumentException("Cannot place " + type + " on top of your pizza.");
        }
        this.toppingType = type;
    }

    private void setWeight(double weight) {      //CHECKED
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * this.weight * CaloriesModifier.getValueFor(this.toppingType);
    }
}
