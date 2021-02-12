package CountMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Box<Double>> boxes = new ArrayList<>();

        while (n-- > 0) {
            String line = scan.nextLine();
            boxes.add(new Box<>(Double.parseDouble(line)));
        }
        String element = scan.nextLine();

        int result = countGreaterElements(boxes, new Box<>(Double.parseDouble(element)));

        System.out.println(result);
    }

    private static <T extends Comparable<T>> int
    countGreaterElements(List<Box<T>> boxes, Box<T> element) {
        int counter = 0;

        for (Box<T> box : boxes) {
            if (box.getValue().compareTo(element.getValue()) > 0) {
                counter++;
            }
        }

        return counter;
    }

}
