public class Car {
    //String model, Engine engine, (opt) int weight, (opt) String color
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    @Override
    public String toString() {
        if (weight == 0){
            return String.format("%s:%n%sWeight: n/a%nColor: %s",
                    this.model, engine.toString(),
                    this.color != null ? this.color : "n/a");
        }else {
            return String.format("%s:%n%sWeight: %d%nColor: %s",
                    this.model, engine.toString(),
                    this.weight,
                    this.color != null ? this.color : "n/a");

        }
    }
}
