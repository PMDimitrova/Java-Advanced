package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MainStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        Arrays.stream(scan.nextLine().split(", "))
                .skip(0)
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        String input = scan.nextLine();

        while (!input.equals("END")){

            if (input.equals("Pop")){
                try {
                    stack.pop();
                }catch (IndexOutOfBoundsException exception){
                    System.out.println(exception.getMessage());
                }
            }else{
                int number = Integer.parseInt(input.substring(input.indexOf(" ") + 1));
                stack.push(number);
            }


            input = scan.nextLine();
        }

        stack.forEach(System.out::println);
    }
}
