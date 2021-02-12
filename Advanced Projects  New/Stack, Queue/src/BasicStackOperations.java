import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int S = scan.nextInt();
        int X = scan.nextInt();
        scan.nextLine();

        ArrayDeque<Integer> stackOfNums = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            stackOfNums.push(num);
        }
        scan.nextLine();

        for (int i = 0; i < S; i++) {
            stackOfNums.pop();
        }

        boolean isXPresent = false;
        int smallestNum = Integer.MAX_VALUE;

        for (int num: stackOfNums) {
            if (num == X){
                isXPresent = true;
            }
            if (num < smallestNum){
                smallestNum = num;
            }
        }

        if (isXPresent){
            System.out.println("true");
        }else {
            if (stackOfNums.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(smallestNum);
            }
        }
    }
}
