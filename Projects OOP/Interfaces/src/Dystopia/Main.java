package Dystopia;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pplCount = Integer.parseInt(scan.nextLine());

        Map<String, Buyer> people = new LinkedHashMap<>();

        for (int i = 0; i < pplCount; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            if (tokens.length == 4){
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                people.put(tokens[0], citizen);
            }else if (tokens.length == 3){
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                people.put(tokens[0], rebel);
            }
        }

        String personBuysFood = scan.nextLine();
        while (!personBuysFood.equals("End")){
            if (people.containsKey(personBuysFood)){
                people.get(personBuysFood).buyFood();
            }
            personBuysFood = scan.nextLine();
        }
        int foodPurchased = 0;

        for (Map.Entry<String, Buyer> person: people.entrySet()) {
            foodPurchased += person.getValue().getFood();
        }

        System.out.println(foodPurchased);
    }
}
