import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();



        String input = scan.nextLine();

        while (!input.equals("JOKER")){
            String[]tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            players.putIfAbsent(name, new HashSet<>());

            Arrays.stream(cards).forEach(card ->{
                players.get(name).add(card);
            });

            input= scan.nextLine();
        }
        Map<String, Integer> playerWithPowers = calculatePlayersCards(players);

        playerWithPowers.entrySet().stream()
                .forEach(player ->{
                    System.out.println(player.getKey() + ": " + player.getValue());
                });

        System.out.println();
    }
//    Slav: 3H, 10S, JC, KD, 5S, 10S
//    Slav: 6H, 7S, KC, KD, 5S, 10C
//    JOKER

    private static Map<String, Integer> calculatePlayersCards(Map<String, Set<String>> players) {
        Map<String, Integer> powers = new LinkedHashMap<>();

        players.entrySet().stream()
                .forEach(player ->{
                    player.getValue().stream().forEach(card ->{
                        int currentPower = calculateCardPower(card);
                        powers.putIfAbsent(player.getKey(),0);
                        powers.put(player.getKey(), powers.get(player.getKey()) + currentPower);
                    });
                });

        return powers;
    }

    private static int calculateCardPower(String card) {
        int type = 0;
        int power = 0;

        if (card.charAt(0) == 'J'){
            power = 11;
        }else if(card.charAt(0) == 'Q'){
            power = 12;
        }else if (card.charAt(0) == 'K'){
            power = 13;
        }else if (card.charAt(0)== 'A'){
            power = 14;
        }else {
            String powerPrime = card.substring(0, card.length()-1);
            power = Integer.parseInt(powerPrime);
        }

        switch (card.charAt(1)){
            case 'S': type = 4; break;
            case 'H': type = 3; break;
            case 'D': type = 2; break;
            case 'C': type = 1; break;
        }

        return type * power;
    }
}
