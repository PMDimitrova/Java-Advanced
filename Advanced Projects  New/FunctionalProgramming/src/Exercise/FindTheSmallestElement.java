package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestElement = list -> {
            int index = -1;
            int smallEl = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= smallEl) {
                    smallEl = list.get(i);
                    index = i;
                }
            }
            return index;
        };

        System.out.println(smallestElement.apply(numbers));
    }
}
