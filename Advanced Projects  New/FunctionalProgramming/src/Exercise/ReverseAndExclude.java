package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        Integer n = Integer.parseInt(scan.nextLine());

        System.out.println(numbers.stream()
                .filter(num -> num % n != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
