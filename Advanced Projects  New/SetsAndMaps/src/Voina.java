import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Integer> firstDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;
        while (rounds-- > 0 && !firstDeck.isEmpty() && !secondDeck.isEmpty()){
            int firstsCard = firstDeck.iterator().next();
            firstDeck.remove(firstsCard);
            int secondsCard = secondDeck.iterator().next();
            secondDeck.remove(secondsCard);

            if (firstsCard>secondsCard){
                firstDeck.add(firstsCard);
                firstDeck.add(secondsCard);
            }else{
                secondDeck.add(secondsCard);
                secondDeck.add(firstsCard);
            }
        }
        if (firstDeck.size() < secondDeck.size()){
            System.out.println("Second player win!");
        }else if (firstDeck.size()> secondDeck.size()){
            System.out.println("First player win!");
        }else{
            System.out.println("Draw!");
        }

    }
}
