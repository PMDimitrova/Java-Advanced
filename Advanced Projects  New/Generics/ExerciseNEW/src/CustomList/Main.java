package CustomList;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] split = input.split("\\s+");
            switch (split[0]) {
                case "Add":
                list.add(split[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(split[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(split[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(split[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
                case "Sort":
                    list.sort();
                    break;
            }


            input = scan.nextLine();
        }
    }
}
