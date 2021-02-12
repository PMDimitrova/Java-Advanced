package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        String criteria = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        Predicate<Person> ageFilter = createAgeFilter(criteria, age); //like a sorting template
        String formatOption = scan.nextLine();

        Function<Person, String> formatter = createFormatter(formatOption);

        String output = people.stream()
                .filter(ageFilter)
                .map(formatter)
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(output);
    }

    private static Function<Person, String> createFormatter(String formatOption) {
            if (formatOption.equals("name")){
                return p -> p.name;
            }else if(formatOption.equals("age")){
                return p -> String.valueOf(p.age);
            }else{
                return p -> p.name + " - " + p.age;
            }
    }

    private static Predicate<Person> createAgeFilter(String criteria, int ageCriteria) {
        if (criteria.equals("older")) {
            return p -> p.age >= ageCriteria;
        }
        return p -> p.age <= ageCriteria;
    }
}
