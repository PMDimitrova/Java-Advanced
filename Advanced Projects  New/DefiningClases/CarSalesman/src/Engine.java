public class Engine {
    //String model, int power, (opt) int displacement, (opt) String efficiency
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    @Override
    public String toString() {
        if (displacement != 0) {
            return String.format("%s:%nPower: %d%nDisplacement: %d%nEfficiency: %s%n",
                    this.model, this.power,
                    this.displacement,
                    this.efficiency != null ? this.efficiency : "n/a");
        } else {
            return String.format("%s:%nPower: %d%nDisplacement: n/a%nEfficiency: %s%n",
                    this.model, this.power,
                    this.efficiency != null ? this.efficiency : "n/a");
        }
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

}
