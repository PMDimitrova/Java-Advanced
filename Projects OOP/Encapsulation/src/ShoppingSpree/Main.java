package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String[] inputPeople = scan.nextLine().split(";");
        String[] inputProducts = scan.nextLine().split(";");

        Map<String, Person> listOfPeople = new LinkedHashMap<>();
        Map<String, Product> listOfProducts = new LinkedHashMap<>();

        boolean isMoneyNegative = false;

        for (String human : inputPeople) {
            try {
                String[] data = human.split("=");
                Person person = new Person(data);
                listOfPeople.put(person.getName(), person);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                isMoneyNegative = true;
                break;
            }
        }

        for (String product : inputProducts) {
            try {
                String[] data = product.split("=");
                Product prod = new Product(data);
                listOfProducts.put(prod.getName(), prod);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                isMoneyNegative = true;
                break;
            }
        }

        String command = scan.nextLine();

        while (!command.equals("END") && !isMoneyNegative) {  //find the buyer and check if he can buyProduct(Product product)
            String[] tokens = command.split("\\s+");
            String personsName = tokens[0];
            String productType = tokens[1];
            Person currentBuyer = listOfPeople.get(personsName);
            Product currentProduct = listOfProducts.get(productType);

            if (currentBuyer.getMoney() >= currentProduct.getCost()) {
                currentBuyer.buyProduct(currentProduct);
                System.out.println(personsName + " bought " + productType);
            } else {
                System.out.printf("%s can't afford %s%n", personsName, productType);
            }
            command = scan.nextLine();
        }

        if (!isMoneyNegative) {
            for (Person person : listOfPeople.values()) {
                System.out.println(person.toString());
            }
        }
    }
}
