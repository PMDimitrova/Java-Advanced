package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {

    private Collection<Drink> models;

    public DrinkRepositoryImpl(){
        this.models = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        Drink drink = null;

        for (Drink drinkPrim:models) {
            if (drinkPrim.getBrand().equals(drinkBrand) && drinkPrim.getName().equals(drinkName)){
                drink = drinkPrim;
            }
        }
        return drink;
    } //+

    public Drink getByName(String name){
        Drink drink = null;

        for (Drink drinkPrim:models) {
            if (drinkPrim.getName().equals(name)){
                drink = drinkPrim;
            }
        }
        return drink;
    } //+
    @Override
    public Collection<Drink> getAll() {//must be unmodifiable
        return Collections.unmodifiableCollection(models);
    }//+

    @Override
    public void add(Drink drink) {
        models.add(drink);
    }//+
}
