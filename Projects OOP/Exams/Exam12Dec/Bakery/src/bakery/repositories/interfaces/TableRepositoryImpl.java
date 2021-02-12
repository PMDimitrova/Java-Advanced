package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> models;

    public TableRepositoryImpl (){
        this.models = new ArrayList<>();
    }
    @Override
    public Collection<Table> getAll() {//must be unmodifiable
        return Collections.unmodifiableCollection(models);
    }//+

    @Override
    public void add(Table table) {
        models.add(table);
    }//+

    @Override
    public Table getByNumber(int number) {
        Table table = null;
        for (Table tablePrim:models) {
            if (tablePrim.getTableNumber() == number){
                table = tablePrim;
            }
        }
        return table;
    }
}
