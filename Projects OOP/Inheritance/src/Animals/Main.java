package Animals;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();

        ArrayList<Animal> animals = new ArrayList<>();

        while (!type.equals("Beast!")) {
            String[] info = scan.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            String gender = info[2];
            Animal animal;
            boolean isInputValid = checkIfInputIsValid(name, age, gender);

            if (isInputValid) {
                switch (type) {
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age, gender);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age, gender);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + type);
                }
                animals.add(animal);

            } else {
                System.out.println("Invalid input!");
            }
            type = scan.nextLine();
        }
        for (Animal animal:animals) {
            System.out.println(animal.toString());
            System.out.println(animal.produceSound());
        }
    }

    private static boolean checkIfInputIsValid(String name, int age, String gender) {
        if (age<0){
            return false;
        }
        if(!gender.equals("Female") && !gender.equals("Male") ){
            return false;
        }
        return true;
    }
}
