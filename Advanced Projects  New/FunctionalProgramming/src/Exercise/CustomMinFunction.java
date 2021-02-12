package Exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        Function<int[], Integer> findMinNum = numbers ->{
            int minNum = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i]<minNum){
                    minNum = numbers[i];
                }
            }
            return minNum;
        };

       int minNum = findMinNum.apply( Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray());
        System.out.println(minNum);
    }
}