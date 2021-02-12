public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand, String model, int horsePower){     //всичко
        this(brand,model);
        this.horsePower = horsePower;
    }

    public Car(String brand, String model){                 //без конете
        this(brand);
        this.model = model;
    }

    public Car (String brand){                              //само марката
        this.brand = brand;
    }


    public String carInfo() {
        String info = String.format("The car is: %s %s - %d HP.",
                this.brand,
                this.model != null ? this.getModel() : "unknown",
                this.horsePower != 0 ? this.getHorsePower() : -1);
        return info;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }
}
