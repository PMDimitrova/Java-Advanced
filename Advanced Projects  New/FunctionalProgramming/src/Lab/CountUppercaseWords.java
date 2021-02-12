package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Predicate<String> startsWithUpperCase = w -> Character.isUpperCase(w.charAt(0));

        List<String> words = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(startsWithUpperCase)
                .collect(Collectors.toList());

        System.out.println(words.size());
        System.out.println(words.stream()
                .collect(Collectors.joining(System.lineSeparator())));

    }
}
