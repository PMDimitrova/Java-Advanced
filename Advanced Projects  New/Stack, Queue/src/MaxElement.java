import java.util.ArrayDeque;
import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       int count = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s+");
            switch (input[0]){
                case "1":
                    int numToAdd = Integer.parseInt(input[1]);
                    stack.push(numToAdd);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    printMaxNumInStack(stack);
                    break;
            }
        }
    }

    private static void printMaxNumInStack(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (int num:stack) {
            if (num>max){
                max = num;
            }
        }
        System.out.println(max);
    }
}
