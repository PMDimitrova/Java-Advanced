package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> checkLength = name -> {
            return name.length() <= n;
        };

        Arrays.stream(names)
                .filter(checkLength)
                .forEach(System.out::println);

    }
}
