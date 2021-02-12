package ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String[] input){
        this.setName(input);
        this.setCost(input);
    }

    private void setCost(String[] input) {
        this.cost = Double.parseDouble(input[1]);
    }

    private void setName(String[] input) {
        this.name = input[0];
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}
