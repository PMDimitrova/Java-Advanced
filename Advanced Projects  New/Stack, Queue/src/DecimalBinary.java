import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalBinary {
    public static void main(String[] args) {

        //LIFO => ArrayDeque (push, pop, peek) - stack
        //FIFO => ArrayDeque (offer, poll, peel) - queue

        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> outputStack = new ArrayDeque<>();

        if (input == 0) {
            outputStack.push(input);
        } else {
            while (input != 0) {
                outputStack.push(input % 2);
                input /= 2;
            }
        }
        while(outputStack.size()>0){
            System.out.print(outputStack.pop());
        }
        System.out.println();

    }
}
