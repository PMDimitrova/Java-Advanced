import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");

        for (int i = input.length-1; i >=0; i--) {
            int num = Integer.parseInt(input[i]);
            String plusMinus = input[i-1];
            if (num>0){}
            i--;
        }

    }
}
