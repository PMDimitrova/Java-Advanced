import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Map<String, Double>> list = new TreeMap<>();
        //  store,   product,  price
        while (!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String store = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            list.putIfAbsent(store, new LinkedHashMap<>());
            list.get(store).put(product, price);

            input = scan.nextLine();
        }
//        fantastico->
//        Product: apple, Price: 1.2
        for (Map.Entry<String, Map<String, Double>> entry : list.entrySet()) {
            System.out.println(entry.getKey() + "->");
            printProducts(entry.getValue());
        }


        System.out.println();
    }

    private static void printProducts(Map<String, Double> productList) {
        productList.entrySet().stream()
                .forEach(entry ->{
                    System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue());
                });
    }
}
