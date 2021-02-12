package Lootbox;
//firstLoot - fifo - queue - offer/poll/peek
//secondLoot - lifo - stack - push/pop/peek

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputOne = scan.nextLine().split("\\s+");
        String[] inputTwo = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> firstLoot = fillArrayDeque(inputOne, "queue");
        ArrayDeque<Integer> secondLoot = fillArrayDeque(inputTwo, "stack");

        int sumClaimedItems = 0;

        while (!firstLoot.isEmpty() && !secondLoot.isEmpty()){
            int first = firstLoot.peek();
            int second = secondLoot.peek();

            if ((first+second)%2 == 0){
                sumClaimedItems += (first+second);
                firstLoot.poll();
                secondLoot.pop();
            }else{
                firstLoot.offer(secondLoot.pop());
            }
        }
        if (firstLoot.isEmpty()){
            System.out.println("First lootbox is empty");
        }else{
            System.out.println("Second lootbox is empty");
        }

        if (sumClaimedItems>=100){
            System.out.printf("Your loot was epic! Value: %d", sumClaimedItems);
        }else{
            System.out.printf("Your loot was poor... Value: %d", sumClaimedItems);
        }
    }

    private static ArrayDeque<Integer> fillArrayDeque(String[] input, String type) {
        ArrayDeque<Integer> output = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            if (type.equals("queue")){
                output.offer(Integer.parseInt(input[i]));
            }else if(type.equals("stack")){
                output.push(Integer.parseInt(input[i]));
            }
        }
        return output;
    }
}
