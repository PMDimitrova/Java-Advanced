package Person;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        List<Birthable> birthableList = new ArrayList<>();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            Birthable birthable = null;
            switch (tokens[0]) {
                case "Citizen":
                    birthable = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    break;

                case "Pet":
                    birthable = new Pet(tokens[1], tokens[2]);
                    break;
                case "Robot":
                    break;
            }
            if (!tokens[0].equals("Robot")) {
                birthableList.add(birthable);
            }
            command = scan.nextLine();
        }
        String birthYear = scan.nextLine();
        for (Birthable thing : birthableList) {
            String year = thing.getBirthDate().substring(thing.getBirthDate().length() - 4);
            if (birthYear.equals(year)) {
                System.out.println(thing.getBirthDate());
            }
        }
    }
}