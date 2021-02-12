package person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        Person person = new Child(name, age);

        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
