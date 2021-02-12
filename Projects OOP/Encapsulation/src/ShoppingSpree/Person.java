package ShoppingSpree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String[] input) {
        this.setName(input[0]);
        this.setMoney(input[1]);
        products = new LinkedList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(String input) {
        double money = Double.parseDouble(input);
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public void buyProduct(Product product) throws Exception {          //?????
        if (product.getCost() >= this.money) {
            throw new Exception(String.format("%s can't afford %s",
                    this.getName(), product.getName()));
        }
        this.money -= product.getCost();
        this.products.add(product);
    }

    @Override
    public String toString() {
        String productsOutput = "Nothing bought ";
        if (!this.products.isEmpty()) {
            productsOutput = products.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", "));
        }
        //productsOutput = productsOutput.substring(0, productsOutput.length() - 1);
        return this.getName() + " - " + productsOutput;
    }
}
