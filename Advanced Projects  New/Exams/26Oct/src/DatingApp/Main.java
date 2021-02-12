package DatingApp;

import java.util.ArrayDeque;
import java.util.Scanner;

//males - stack - push/pop/peek
//females - queue - offer/poll/peek

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputM = scan.nextLine().split("\\s+");
        String[] inputF = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> stackOfMales = fillTheArrayDeque(inputM, "stack");
        ArrayDeque<Integer> queueOfFemales = fillTheArrayDeque(inputF, "queue");

        int matchesMade = 0;

        boolean noneMalesLeft = false;
        boolean noneFemalesLeft = false;

        while (!noneMalesLeft && !noneFemalesLeft) {
            int male = stackOfMales.peek();
            int female = queueOfFemales.peek();//check if the person in line is divisible by 25

            if (checkDivisionBy25(stackOfMales, "stack") || checkDivisionBy25(queueOfFemales, "queue")){
                noneMalesLeft = checkIfAnyPplAreLeft(stackOfMales);
                noneFemalesLeft = checkIfAnyPplAreLeft(queueOfFemales);
                continue;
            }

            if(checkIfPersonIsZero(stackOfMales, "stack") || checkIfPersonIsZero(queueOfFemales, "queue")){
                noneMalesLeft = checkIfAnyPplAreLeft(stackOfMales);
                noneFemalesLeft = checkIfAnyPplAreLeft(queueOfFemales);
                continue;
            }

            stackOfMales.pop();
            queueOfFemales.poll();

            if (male == female) {
                matchesMade++;
            } else {
                male -=2;
                stackOfMales.push(male);
            }
            noneMalesLeft = checkIfAnyPplAreLeft(stackOfMales);
            noneFemalesLeft = checkIfAnyPplAreLeft(queueOfFemales);
        }
        System.out.println("Matches: " + matchesMade);
        System.out.println("Males left: " +
                (stackOfMales.size() > 0 ? stackOfMales.toString().replaceAll("[\\[\\]]", "") : "none"));
        System.out.println("Females left: " +
                (queueOfFemales.size() > 0 ? queueOfFemales.toString().replaceAll("[\\[\\]]", "") : "none"));

    }

    private static boolean checkIfPersonIsZero(ArrayDeque<Integer> input, String type) {
        if (input.peek()<=0){
            if (type.equals("stack")){
                input.pop();
                return true;
            }else if (type.equals("queue")){
                input.poll();
                return true;
            }
        }
        return false;
    }

    private static boolean checkDivisionBy25(ArrayDeque<Integer> input, String type) {
        if (input.peek() % 25 == 0 && !(input.peek()==0) ) {    //is 0 to be taken into account??
            if (type.equals("stack")) {
                input.pop();
                if (input.size()>0){
                    input.pop();
                }
                return true;
            } else if (type.equals("queue")) {
                input.poll();
                if (input.size()>0){
                    input.poll();
                }
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfAnyPplAreLeft(ArrayDeque<Integer> input) {
        return input.size() <= 0;
    }

    private static ArrayDeque<Integer> fillTheArrayDeque(String[] input, String type) {
        ArrayDeque<Integer> output = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            if (type.equals("queue")) {
                output.offer(Integer.parseInt(input[i]));
            } else if (type.equals("stack")) {
                output.push(Integer.parseInt(input[i]));
            }
        }
        return output;
    }
}
