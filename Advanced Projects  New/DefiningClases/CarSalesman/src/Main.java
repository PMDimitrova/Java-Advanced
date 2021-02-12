import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countEngines = Integer.parseInt(scan.nextLine());
        //<Model> <Power> --<Displacement> --<Efficiency>

        Map<String, Engine> listOfEngines = new HashMap<>();

        String[] data;

        for (int i = 0; i < countEngines; i++) {
            data = scan.nextLine().split("\\s+");
            String model = data[0];
            int power = Integer.parseInt(data[1]);
            int displacement = -1;
            String efficiency = "";

            Engine engine;

            if (data.length == 2) {
                engine = new Engine(model, power);
            } else if (data.length == 4) {
                displacement = Integer.parseInt(data[2]);
                efficiency = data[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else {
                try {
                    displacement = Integer.parseInt(data[2]);
                    engine = new Engine(model, power, displacement);
                } catch (Exception e) {
                    efficiency = data[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            listOfEngines.put(model, engine);
        }

        int countCars = Integer.parseInt(scan.nextLine());
        //<Model> <Engine> --<Weight> --<Color>
        List<Car> cars = new LinkedList<>();

        for (int i = 0; i < countCars; i++) {
            data = scan.nextLine().split("\\s+");
            String model = data[0];
            Engine engine = listOfEngines.get(data[1]);
            int weight = -1;
            String color = "";

            Car car;
            if (data.length ==2){
                car = new Car(model, engine);
            }else if (data.length == 4){
                weight = Integer.parseInt(data[2]);
                color = data[3];
                car = new Car(model, engine, weight, color);
            }else{
                try{
                    weight = Integer.parseInt(data[2]);
                    car = new Car(model, engine, weight);
                }catch (Exception e){
                    color = data[2];
                    car = new Car(model, engine, color);
                }
            }
            cars.add(car);
        }
        for (Car c:cars) {
            System.out.println(c.toString());
        }
        System.out.println();
    }
}
