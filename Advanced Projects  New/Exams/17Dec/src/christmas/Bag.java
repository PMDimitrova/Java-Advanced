package christmas;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.DoubleToIntFunction;

public class Bag {
    private String color;
    private int capacity;
    private Map<String, Present> data;

    public Bag (String color, int capacity){
        this.color = color;
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
    }

    public String report(){
        String output =  Character.toUpperCase(this.color.charAt(0)) +this.color.substring(1);
                output += " bag contains:" +System.lineSeparator();
        for (Map.Entry<String, Present> entry : data.entrySet()) {
            output += entry.getValue().toString() + System.lineSeparator();
        }
        return output;
    }

    public Present getPresent(String name){
        return data.get(name);
    }

    public Present heaviestPresent(){
        Present present = new Present();

        for (Map.Entry<String, Present> entry : data.entrySet()) {
            if (entry.getValue().getWeight() > present.getWeight()){
                present = entry.getValue();
            }
        }
        return present;
    }

    public boolean remove(String name){
        if (data.containsKey(name)){
            data.remove(name);
            return true;
        }
        return false;
    }

    public void add(Present present){
        if (data.size()<capacity){
            data.put(present.getName(), present);
        }
    }

    public int count(){
        return this.data.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getColor() {
        return color;
    }
}
