package rabbits;

public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species){
        this.name = name;
        this.species = species;
        this.available = true;
    }
    public Rabbit(){

    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean availability) {
        this.available = availability;
    }

    @Override
    public String toString() {
        return "Rabbit (" + this.species + "): " + this.name;
    }
}
