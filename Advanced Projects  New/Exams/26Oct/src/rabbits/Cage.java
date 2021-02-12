package rabbits;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String report(){
        String output = String.format("Rabbits available at %s:%n", this.name);
        for (Rabbit rabbit:data ){
            if (rabbit.isAvailable()){
                output += rabbit.toString() + System.lineSeparator();
            }
        }
        return output;
    }

    public List<Rabbit> sellRabbitBySpecies(String species){    //should we get them out of the cage
       List<Rabbit> sold = new ArrayList<>();
        for (Rabbit rabbit:this.data) {
            if (rabbit.getSpecies().equals(species)){
                rabbit.setAvailable(false);
                sold.add(rabbit);
            }
        }
        return sold;
    }

    public Rabbit sellRabbit(String name){
        Rabbit output = new Rabbit();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)){
                output = rabbit;
                rabbit.setAvailable(false);
            }
        }
        return output;
    }

    public void removeSpecies(String name){
        List<Rabbit> rabbitsToRemove = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(name)){
                rabbitsToRemove.add(rabbit);
            }
        }
        for (Rabbit r: rabbitsToRemove) {
            this.data.remove(r);
        }
    }
    public int count(){
        return this.data.size();
    }

    public boolean removeRabbit(String name){
        boolean remove = false;
        Rabbit rabbitToRemove = new Rabbit();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)){
                remove = true;
                rabbitToRemove = rabbit;
            }
        }
        this.data.remove(rabbitToRemove);
        return remove;
    }

    public void add(Rabbit rabbit){
        if (this.data.size() <this.capacity){
           this.data.add(rabbit);
        }
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
