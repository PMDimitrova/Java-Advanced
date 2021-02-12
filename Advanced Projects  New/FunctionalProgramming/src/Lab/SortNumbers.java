package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], String> getCountStr =
                array -> String.format("Count = %d", array.length);

        System.out.println(getCountStr.apply(nums));

        Function<int[], String> getSum =
                arr -> {
                   return "Sum = " + Arrays.stream(arr).sum();
                };

        System.out.println(getSum.apply(nums));
    }
}
