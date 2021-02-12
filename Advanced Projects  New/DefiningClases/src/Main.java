import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        String[] tokens = new String[3];

        List<Car> cars = new ArrayList<>();

        Car car;

        for (int i = 0; i < count; i++) {
            tokens = scan.nextLine().split("\\s+");
            if (tokens.length == 1){
                car = new Car(tokens[0]);
            }else if (tokens.length == 2){
                car = new Car(tokens[0], tokens[1]);
            }else {
                car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            cars.add(car);
        }
        for (Car currentCar : cars) {
            System.out.println(currentCar.carInfo());
        }
    }
}
