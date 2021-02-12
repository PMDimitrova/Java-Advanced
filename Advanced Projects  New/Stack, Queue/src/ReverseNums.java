import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<Integer> output = new ArrayDeque<>();
        for (String s:input) {
            int num = Integer.parseInt(s);
            output.push(num);
        }
        while (!output.isEmpty()){
            System.out.print(output.pop() + " ");
        }
    }
}
