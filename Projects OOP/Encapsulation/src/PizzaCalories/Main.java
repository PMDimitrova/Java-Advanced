package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] pizzaData = scan.nextLine().split("\\s+");
        Pizza pizza;

        try {
            pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String[] doughData = scan.nextLine().split("\\s+");
        try {
            Dough dough = new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));
            pizza.setDough(dough);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }
        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] toppingData = input.split("\\s+");
            try {
                Topping topping = new Topping(toppingData[1], Double.parseDouble(toppingData[2]));
                pizza.addTopping(topping);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            input = scan.nextLine();
        }

        System.out.println(pizza.toString());

    }
}
