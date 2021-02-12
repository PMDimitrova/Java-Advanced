public class Car {
    private String model;
    private int speed;

    public Car (String model, String speed){
        this.model = model;
        this.speed = Integer.parseInt(speed);
    }

    @Override
    public String toString() {
        return String.format("Car:%n%s %d", this.model, this.speed);
    }
}
