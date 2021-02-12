package GenericBox;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        int n = Integer.parseInt(scan.nextLine());
//
//        List<Box<String>> boxes = new ArrayList<>();
//
//        while (n-->0){
//            String line = scan.nextLine();
//
//            Box<String> box = new Box<String>(line);
//            boxes.add(box);
//        }
//
//        int first = scan.nextInt();
//        int second = scan.nextInt();
//
//        swap(boxes, first, second);

    }

    private static <T> void swap(List<Box<T>> boxes, int first, int second) {
       Box <T> temp = boxes.get(first);

       boxes.set(first, boxes.get(second));
       boxes.set(second, temp);
    }
}
