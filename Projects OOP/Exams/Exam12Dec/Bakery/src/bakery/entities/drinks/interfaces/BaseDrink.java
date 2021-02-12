package bakery.entities.drinks.interfaces;

import bakery.entities.bakedFoods.interfaces.BaseFood;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseDrink implements Drink{
    private String name;
    private int portion;
    private double price;
    private String brand;

    protected BaseDrink(String name, int portion, double price, String brand){
        setName(name);
        setPortion(portion);
        setPrice(price);
        setBrand(brand);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }//+

    public void setPortion(int portion) {
        if (portion<1){
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }//+

    public void setPrice(double price) {
        if (price<1){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }//+

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }//+

    @Override
    public String getName() {
        return this.name;
    }//+

    @Override
    public int getPortion() {
        return this.portion;
    }//+

    @Override
    public double getPrice() {
        return this.price;
    }//+

    @Override
    public String getBrand() {
        return this.brand;
    }//+

    @Override
    public String toString() {
        return String.format("%s %s - %dml - %.2flv",
                this.getName(),
                this.getBrand(),
                this.getPortion(),
                this.getPrice());
    }
}
