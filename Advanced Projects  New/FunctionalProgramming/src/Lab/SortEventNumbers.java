package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEventNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");

        String output = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .filter(num -> num %2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(output);

       output = Arrays.stream(output.split(", "))
                .mapToInt(Integer::parseInt)
                .sorted()
               .mapToObj(e -> String.valueOf(e))
               .collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
