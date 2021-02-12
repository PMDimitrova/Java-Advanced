package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private Collection<BakedFood> models;

    public FoodRepositoryImpl(){
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        BakedFood food = null;
        for (BakedFood foodPrim:models) {
            if (foodPrim.getName().equals(name)){
                food = foodPrim;
            }
        }
        return food;
    }//+

    @Override
    public Collection<BakedFood> getAll() { //must be unmodifiable
        return Collections.unmodifiableCollection(models);
    }//+

    @Override
    public void add(BakedFood bakedFood) {
        models.add(bakedFood);
    }//+
}
