package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.BaseFood;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.BaseTable;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository,
                          DrinkRepository<Drink> drinkRepository,
                          TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.totalIncome = 0;

    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood food = foodRepository.getByName(name);

        if (!(food == null)) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }   //todo check if on upper level we need food type or className
        switch (type) {
            case "Bread":
                food = new Bread(name, 0, price);
                break;
            case "Cake":
                food = new Cake(name, 0, price);
                break;
        }
        foodRepository.add(food);

        return String.format(FOOD_ADDED, name, type);
    } //+

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = drinkRepository.getByNameAndBrand(name, brand);

        if (!(drink == null)) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }   //todo check if on upper level we need food type or className
        switch (type) {
            case "Tea":
                drink = new Tea(name, portion, 0, brand);
                break;
            case "Water":
                drink = new Water(name, portion, 0, brand);
                break;
        }
        drinkRepository.add(drink);
        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (!(table == null)) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }
        switch (type) {
            case "InsideTable":
                table = new InsideTable(tableNumber, capacity, 0);
                break;
            case "OutsideTable":
                table = new OutsideTable(tableNumber, capacity, 0);
                break;
        }
        tableRepository.add(table);

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        int tableNr = 0;

        for (Table table : tableRepository.getAll()) {
            if (!table.isReserved() && table.getCapacity() >= numberOfPeople) {
                tableNr = table.getTableNumber();
                table.reserve(numberOfPeople);
                break;
            }
        }
        if (tableNr > 0) {
            return String.format(TABLE_RESERVED, tableNr, numberOfPeople);
        } else {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
    }
    //FROM HERE
    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = tableRepository.getByNumber(tableNumber);
        BakedFood food = foodRepository.getByName(foodName);
        if (table == null || !table.isReserved()) {
            throw new IllegalArgumentException(String.format(WRONG_TABLE_NUMBER, tableNumber));
        }
        if (food == null){
            throw new IllegalArgumentException(String.format(NONE_EXISTENT_FOOD, foodName));
        }
        table.orderFood(food);
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = tableRepository.getByNumber(tableNumber);
        Drink drink = drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        if (table == null || !table.isReserved()) {
            throw new IllegalArgumentException(String.format(WRONG_TABLE_NUMBER, tableNumber));
        }
        if (drink == null){
            throw new IllegalArgumentException(String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand));
        }
        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getByNumber(tableNumber);
        double billForTable = table.getBill();
        totalIncome += billForTable;
        table.clear();

        return String.format(BILL, tableNumber, billForTable);
    }

    @Override
    public String getFreeTablesInfo() {
        String output = "";
        for (Table table : tableRepository.getAll()) {
            if (!(table.isReserved())){
                output += table.getFreeTableInfo() +System.lineSeparator();
            }

        }
        return output;
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
