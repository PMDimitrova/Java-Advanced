import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.length() % 2 == 1) {
            System.out.println("NO");

        } else {

            ArrayDeque<Character> stackFirstHalf = new ArrayDeque<>();
            ArrayDeque<Character> queueSecondHalf = new ArrayDeque<>();

            int lastIndOfFirstHalf = input.length() / 2 - 1;
            for (int i = 0; i <= lastIndOfFirstHalf; i++) {         //наливаме първата половина в стек
                stackFirstHalf.push(input.charAt(i));
            }
            for (int i = lastIndOfFirstHalf + 1; i < input.length(); i++) {  //наливаме втората половина
                queueSecondHalf.offer(input.charAt(i));
            }

            boolean isBalanced = true;

            while (!stackFirstHalf.isEmpty()) {
                char firstHalf = stackFirstHalf.pop();
                char secondHalf = queueSecondHalf.poll();

                switch (firstHalf) {
                    case '{':
                        if (!(secondHalf == '}')) {
                            isBalanced = false;
                        }
                        break;
                    case '[':
                        if (!(secondHalf == ']')) {
                            isBalanced = false;
                        }
                        break;
                    case '(':
                        if (!(secondHalf == ')')) {
                            isBalanced = false;
                        }
                        break;
                }
            }
            if (isBalanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
