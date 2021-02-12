package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strings = Arrays.stream(scan.nextLine().split("\\s+"))
                .skip(1)
                .toArray(String[]::new);

        ListlyIterator listlyIterator = new ListlyIterator(strings);

        String input = scan.nextLine();

        while (!input.equals("END")) {
            switch (input) {
                case "Move":
                    System.out.println(listlyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listlyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        System.out.println(listlyIterator.print());
                    } catch (UnsupportedOperationException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "PrintAll":
                    listlyIterator.forEach(elem ->{
                        System.out.print(elem + " ");
                    });
                    System.out.println();
                    break;
            }

            input = scan.nextLine();
        }
    }
}