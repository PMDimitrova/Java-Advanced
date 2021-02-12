package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(){

    }

    public Pizza (String name, int numberOfToppings ){
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    public void addTopping (Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories(){
        double output = 0;
        output += this.dough.calculateCalories();
        for (Topping topping:this.toppings) {
            output +=topping.calculateCalories();
        }
        return output;
    }

    private void setName(String name) {
        name = name.trim();
        if (name.isEmpty() || name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) { //todo write logic
        if (numberOfToppings >10 || numberOfToppings<1){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " - " + String.format("%.2f", this.getOverallCalories());
    }
}
