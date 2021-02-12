package FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Scanner;

//lilies - stack - lifo - push/pop/peek
//roses - queue - fifo - offer/poll/peek

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputLily = scan.nextLine().split(", ");
        String[] inputRose = scan.nextLine().split(", ");

        ArrayDeque<Integer> stackOfLilies = new ArrayDeque<Integer>(createStack(inputLily));
        ArrayDeque<Integer> queueOfRoses = new ArrayDeque<Integer>(createQueue(inputRose));

        int wreaths = 0;
        int storedFlowers = 0;

        while (!stackOfLilies.isEmpty() && !queueOfRoses.isEmpty()){
            int lilies = stackOfLilies.peek();
            int roses = queueOfRoses.peek();
            int sumFlowers = lilies + roses;
            if (sumFlowers==15){
                wreaths++;
                stackOfLilies.pop();
                queueOfRoses.poll();
            }else if(sumFlowers>15){
                while (sumFlowers>15){
                    lilies -=2;
                    sumFlowers = lilies + roses;
                    if (sumFlowers==15){
                        wreaths++;
                        stackOfLilies.pop();
                        queueOfRoses.poll();
                    }else if (sumFlowers<15){
                        storedFlowers = storedFlowers + roses + lilies;
                        stackOfLilies.pop();
                        queueOfRoses.poll();
                    }
                }
            }else {
                storedFlowers = storedFlowers + roses + lilies;
                stackOfLilies.pop();
                queueOfRoses.poll();
            }

        }

        while (storedFlowers>15){
            wreaths++;
            storedFlowers -=15;
        }

        if (wreaths>4){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        }else{
            System.out.printf("You didn't make it, you need %d wreaths more!", (5 -  wreaths));
        }
    }

    private static ArrayDeque<Integer> createQueue(String[] inputRose) {
        ArrayDeque<Integer> output = new ArrayDeque<>();
        for (String num :inputRose) {
            int number = Integer.parseInt(num);
            output.offer(number);
        }
        return output;
    }

    private static ArrayDeque<Integer> createStack(String[] inputLily) {
        ArrayDeque<Integer> output = new ArrayDeque<>();
        for (String num :inputLily) {
            int number = Integer.parseInt(num);
            output.push(number);
        }
        return output;
    }

}
