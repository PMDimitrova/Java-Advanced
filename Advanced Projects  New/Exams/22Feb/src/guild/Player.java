package guild;

public class Player {
    private String name;
    private String clazz;
    private String rank; //Trial by default
    private String description; //n/a by default

    public Player(String name, String clazz){
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    @Override
    public String toString() {
        return String.format("Player %s: %s%nRank: %s%nDescription: %s%n",
                this.name, this.clazz, this.rank, this.description);
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getClazz() {
        return clazz;
    }

    public String getDescription() {
        return description;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setName(String name) {
        this.name = name;
    }
}
