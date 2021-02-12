package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int startPoint = Integer.parseInt(input[0]);
        int endPoint = Integer.parseInt(input[1]);
        String criteria = scan.nextLine();
        List<Integer> nums = createList(startPoint, endPoint);

        Predicate<Integer> filterByCriteria = createFilter(criteria);

        String output = nums.stream()
                .filter(filterByCriteria)
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }

    private static List<Integer> createList(int startPoint, int endPoint) {
        List<Integer> output = new ArrayList<>();
        for (int i = startPoint; i <= endPoint; i++) {
            output.add(i);
        }
        return output;
    }

    private static Predicate<Integer> createFilter(String criteria) {
        if (criteria.equals("even")) {
            return num -> num % 2 == 0;
        } else {
            return num -> (num % 2 == 1) || (num% 2 ==-1);
        }
    }
}
