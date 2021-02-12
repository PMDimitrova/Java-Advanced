package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getStatistics(){
        String output = "The clinic has the following patients:" + System.lineSeparator();
        for (Pet pet : this.data){
            output += pet.getName() + " " + pet.getOwner()+ System.lineSeparator();
        }
        return output;
    }

    public int getCount(){
        return this.data.size();
    }

    public Pet getOldestPet(){
        Pet output = new Pet();
        for(Pet pet: this.data){
            if (pet.getAge()> output.getAge()){
                output = pet;
            }
        }
        return output;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            this.data.add(pet);
        }
    }
}
