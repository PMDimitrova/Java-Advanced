package Boxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String input = "";

        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            input = scan.nextLine();
            Box box = new Box(input);
            boxes.add(box);
        }
        int first = scan.nextInt();
        int second = scan.nextInt();
        
        swap(boxes, first, second);

        for (Box b:boxes) {
            System.out.println(b.toString());
        }
    }

    private static <T> void swap(List<T> boxes, int first, int second) {
        T element = boxes.get(first);
        boxes.set(first, boxes.get(second));
        boxes.set(second, element);
    }
}
