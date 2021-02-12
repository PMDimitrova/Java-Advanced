public class Engine {
    private int speed;
    private int power;

    public Engine (String speed, String power){
        this.speed = Integer.parseInt(speed);
        this.power = Integer.parseInt(power);
    }

    public int getPower() {
        return power;
    }
}
