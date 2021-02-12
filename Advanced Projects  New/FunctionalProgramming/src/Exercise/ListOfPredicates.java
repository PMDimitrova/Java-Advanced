package Exercise;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static BiPredicate<Integer, Integer>predicate = (f, s) ->f % s == 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Set<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        checkNumbers(1, numbers,n);
    }

    private static void checkNumbers(int num, Set<Integer> numbers, int n) {
        if (num >n){
            return;
        }
        boolean isValid = true;
        for (Integer number : numbers) {
            if (!predicate.test(num, number)){
                isValid = false;
                break;
            }
        }
        if (isValid){
            System.out.print(num + " ");
        }
        checkNumbers(num +1, numbers, n);
    }

}
