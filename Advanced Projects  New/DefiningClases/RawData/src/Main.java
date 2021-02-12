import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        String[] data;

        List<Car> fragileCars = new LinkedList<>();
        List<Car> flamableCars = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            data = scan.nextLine().split("\\s+");
            //    0         1               2
            //"<Model> <EngineSpeed> <EnginePower>
            //      3           4
            // <CargoWeight> <CargoType>
            //      5              6        7               8           9               10
            // <Tire1Pressure><Tire1Age><Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age>
            //      11            12
            // <Tire4Pressure><Tire4Age>
            String carModel = data[0];
            Engine engine = new Engine(data[1], data[2]);
            Cargo cargo = new Cargo(data[3], data[4]);
            List<Tire> tires = fillTiresList(data);
            Car car = new Car(carModel, engine, cargo, tires);
            if (cargo.getType().equals("fragile")){
                if (aTireHaveLowPressure(tires)){
                    fragileCars.add(car);
                }
            }else{
                if (carHavePowerfulEngine(engine)){
                    flamableCars.add(car);
                }
            }
        }

        String command = scan.nextLine();
        if (command.equals("fragile")){
            for (Car c:fragileCars) {
                System.out.println(c.getModel());
            }
        }else {
            for (Car c: flamableCars) {
                System.out.println(c.getModel());
            }
        }
    }

    private static boolean carHavePowerfulEngine(Engine engine) {
        int enginePower = engine.getPower();
        if (enginePower>250){
            return true;
        }
        else return false;
    }

    private static boolean aTireHaveLowPressure(List<Tire> tires) {
        for (int i = 0; i < tires.size(); i++) {
            Tire currentTire = tires.get(i);
            if (currentTire.getPressure()< 1){
               return true;
            }
        }
        return false;
    }

    private static List<Tire> fillTiresList(String[] data) {
        List<Tire> tires = new LinkedList<>();
        int count = 5;
        for (int i = 0; i < 4; i++) {
            Tire currentTire = new Tire(data[count], data[count + 1]);
            count += 2;
            tires.add(currentTire);
        }
        return tires;
    }
}
