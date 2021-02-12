package Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        UnaryOperator<Double> addVat = num -> num *1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(scan.nextLine().split(", "))
                .mapToDouble(e -> addVat.apply(Double.parseDouble(e)))
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
