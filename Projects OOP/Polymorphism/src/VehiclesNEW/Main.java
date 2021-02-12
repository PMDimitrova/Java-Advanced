package VehiclesNEW;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        for (int i = 0; i < 3; i++) {
            String[] inputData = scan.nextLine().split("\\s+");
            Vehicle vehicle = new Vehicle() {};
            switch (inputData[0]){
                case "Car":
                    vehicle = new Car(Double.parseDouble(inputData[1]), Double.parseDouble(inputData[2]), Double.parseDouble(inputData[3]));
                    break;
                case "Truck":
                    vehicle = new Truck(Double.parseDouble(inputData[1]), Double.parseDouble(inputData[2]), Double.parseDouble(inputData[3]));
                    break;
                case "Bus":
                    vehicle = new Bus(Double.parseDouble(inputData[1]), Double.parseDouble(inputData[2]), Double.parseDouble(inputData[3]));
                    break;
            }

            vehicles.put("Car", vehicle);
        }

        int commandsCount = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < commandsCount; i++) {
            String[] command = scan.nextLine().split("\\s+");
            double argument = Double.parseDouble(command[2]);   //either kms or litres

            if (command[0].equals("Drive")){
                System.out.println(vehicles.get(command[1]).drive(argument));
            }else if (command[0].equals("DriveEmpty")){

            }else {
                vehicles.get(command[1]).refuel(argument);
            }
        }
        for (Vehicle vehicle:vehicles.values()) {
            System.out.println(vehicle.toString());
        }

    }
}
