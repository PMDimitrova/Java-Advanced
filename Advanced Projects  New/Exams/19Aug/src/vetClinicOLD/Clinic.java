package vetClinicOLD;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<Pet>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String petName) {
        for (Pet pet : data) {
            if (pet.getName().equals(petName)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String petName, String ownersName) {
        for (Pet pet : data) {
            if (pet.getName().equals(petName) && pet.getOwner().equals(ownersName)){
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet(){
        Pet oldestPet = new Pet();
        int oldest = -1;
        for (Pet pet : data) {
            if (oldest < pet.getAge()){
                oldestPet = pet;
                oldest = pet.getAge();
            }
        }
        return oldestPet;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics(){
        String output = String.format("This clinic has the following patients:%n");
        for (Pet pet : data) {
            output += pet.forClinicStatistics() + System.lineSeparator();
        }

        return output;
    }
}
