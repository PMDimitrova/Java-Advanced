package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.tableNumber = tableNumber;
        setCapacity(capacity);
        this.numberOfPeople = 0;
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        setPrice(0);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {    //todo check if capacity can be 0
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    } //+

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    } //+

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    } //+

    @Override
    public int getCapacity() {
        return this.capacity;
    } //+

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    } //+

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    } //+

    @Override
    public boolean isReserved() {
        return this.isReserved;
    } //+

    @Override
    public double getPrice() {
        return this.price;
    } //+

    @Override
    public void reserve(int numberOfPeople) {
        isReserved = true;
        setNumberOfPeople(numberOfPeople); //todo check if the numOfPpl which are reserved for,
        // should be the field numberOfPeople

    }//+-

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food); //todo not sure it should be this way
    } //+-

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);    //todo not sure it should be this way
    }

    @Override
    public double getBill() {
        double output = 0;

        for (Drink drink : drinkOrders) {
            output += drink.getPrice();
        }

        for (BakedFood food : foodOrders) {
            output += food.getPrice();
        }
        output += (pricePerPerson*numberOfPeople); //todo should we calculate this here????
        return output;
    } //+

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.isReserved = false;
        this.numberOfPeople = 0;
        setPrice(0);
    }

    @Override
    public String getFreeTableInfo() {
        return String.format("Table: %d%nType: %s%nCapacity: %d%nPrice per Person: %.2f",
                this.getTableNumber(),
                getClass().getSimpleName(),
                this.getCapacity(),
                this.getPricePerPerson());
    }
}
