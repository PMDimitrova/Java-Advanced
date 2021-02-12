public class Cargo {
    private int weight;
    private String type;

    public Cargo(String weight, String type) {
        this.weight = Integer.parseInt(weight);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
