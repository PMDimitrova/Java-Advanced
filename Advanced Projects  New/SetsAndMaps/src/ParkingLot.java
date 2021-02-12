import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String direction = tokens[0];
            String carPlate = tokens[1];

            if (direction.equals("IN")) {
                parking.add(carPlate);
            } else if (direction.equals("OUT")) {
                parking.remove(carPlate);
            }
            input = scan.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {

            for (String car : parking) {
                System.out.println(car);
            }
        }
    }
}

