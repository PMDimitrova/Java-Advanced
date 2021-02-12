import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)== '('){
                indexes.push(i);
            }else if (input.charAt(i) == ')'){
                int startIndx = indexes.pop();
                String toPrint = input.substring(startIndx, i+1);
                System.out.println(toPrint);
            }
        }
    }
}
