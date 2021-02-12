public class Tire {
    private int age;
    private double pressure;


    public Tire(String pressure, String age) {
        this.age = Integer.parseInt(age);
        this.pressure = Double.parseDouble(pressure);
    }

    public double getPressure() {
        return pressure;
    }
}
