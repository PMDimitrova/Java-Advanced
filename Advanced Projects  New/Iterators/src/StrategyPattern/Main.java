package StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Set<Person> byName = new TreeSet<>(new PersonComparatorByName());
        Set<Person> byAge = new TreeSet<>(new PersonComparatorByAge());

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            byName.add(person);
            byAge.add(person);
        }

        byName.forEach(System.out::println);

        byAge.forEach(System.out::println);
    }
}
