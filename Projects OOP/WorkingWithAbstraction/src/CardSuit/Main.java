package CardSuit;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        Arrays.stream(Suit.values())
                .forEach(suit -> System.out.println(suit.toString()));
    }
}
