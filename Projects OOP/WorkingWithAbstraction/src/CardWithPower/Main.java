package CardWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputName = scan.nextLine();
        String inputSuit = scan.nextLine();

        Card card = new Card(CardRank.valueOf(inputName), Suit.valueOf(inputSuit));
        System.out.println(card);
    }
}
