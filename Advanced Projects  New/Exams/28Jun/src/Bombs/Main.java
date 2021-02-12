package Bombs;

import java.util.*;
//bomb effect - FIFO - queue - offer/poll/peek
//bomb casting - LIFO - stack - push/pop/peek

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputEffects = scan.nextLine().split(", ");
        String[] inputCasting = scan.nextLine().split(", ");
        int daturaBomb = 40;
        int cherryBomb = 60;
        int smokeDecoyBomb = 120;

        Map<String, Integer> bombs = new TreeMap<>();
        fillBombs(bombs);
        //type of bomb,  count per type
        ArrayDeque<Integer> effectsQueue = createEffects(inputEffects);
        ArrayDeque<Integer> castingStack = createCastings(inputCasting);
        boolean pouchIsFilled = false;
        while (!effectsQueue.isEmpty() && !castingStack.isEmpty()) {
            int currentEffect = effectsQueue.peek();
            int currentCasting = castingStack.peek();

            String createdBomb = checkIfBombIsCreated(currentEffect, currentCasting);
            if (createdBomb.equals("Datura Bombs")){
                addToBombsList(bombs,"Datura Bombs");
                clearEffectsAndCastings(effectsQueue, castingStack);
            }else if (createdBomb.equals("Cherry Bombs")){
                addToBombsList(bombs, "Cherry Bombs");
                clearEffectsAndCastings(effectsQueue, castingStack);
            }else if (createdBomb.equals("Smoke Decoy Bombs")){
                addToBombsList(bombs, "Smoke Decoy Bombs");
                clearEffectsAndCastings(effectsQueue, castingStack);
            }else{
                int newCasting = castingStack.pop() - 5;
                castingStack.push(newCasting);
            }
            if (pouchIsFilled = findIfPouchIsFilled(bombs)){
                break;
            }
        }

        if (pouchIsFilled){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effectsQueue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else{
            printRemainingEffects(effectsQueue);
        }

        if (castingStack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else{
            printRemainingCastings(castingStack);
        }

        bombs.entrySet().stream()
                .forEach(bomb ->{
                    System.out.println(bomb.getKey() + ": " + bomb.getValue());
                });

        System.out.println();
    }

    private static void fillBombs(Map<String, Integer> bombs) {
        bombs.put("Cherry Bombs",0 );
        bombs.put("Datura Bombs",0 );
        bombs.put("Smoke Decoy Bombs",0 );
    }

    private static void printRemainingCastings(ArrayDeque<Integer> castingStack) {
        String casting = "";
        while (!castingStack.isEmpty()){
            casting = casting + castingStack.poll() +", ";
        }
        casting = casting.substring(0, casting.length() - 2);
        System.out.printf("Bomb Casings: %s%n", casting);
    }

    private static void printRemainingEffects(ArrayDeque<Integer> effectsQueue) {
        String effects = "";
        while (!effectsQueue.isEmpty()){
            effects = effects + effectsQueue.poll() +", ";
        }
        effects = effects.substring(0, effects.length() - 2);
        System.out.printf("Bomb Effects: %s%n", effects);
    }

    private static boolean findIfPouchIsFilled(Map<String, Integer> bombs) {
        if (bombs.size()<3){
            return false;
        }
        int countDatura = bombs.get("Datura Bombs");
        int countCherry = bombs.get("Cherry Bombs");
        int countSmoke = bombs.get("Smoke Decoy Bombs");
        return countDatura > 2 && countCherry > 2 && countSmoke > 2;
    }

    private static void clearEffectsAndCastings(ArrayDeque<Integer> effectsQueue, ArrayDeque<Integer> castingStack) {
        effectsQueue.poll();
        castingStack.pop();
    }

    private static void addToBombsList(Map<String, Integer> bombs, String input) {
        bombs.put(input, (bombs.get(input) +1));
    }

    private static String checkIfBombIsCreated(int currentEffect, int currentCasting) {
        String output = "";
        int sum = currentEffect + currentCasting;
        if (sum == 40){
            output = "Datura Bombs";
        }else if (sum == 60){
            output = "Cherry Bombs";
        }else if (sum == 120){
            output = "Smoke Decoy Bombs";
        }else{
            output = "none";
        }
        return output;
    }


    private static ArrayDeque<Integer> createEffects(String[] input) {
        ArrayDeque<Integer> output = new ArrayDeque<>();
        Arrays.stream(input)
                .forEach(e -> {
                    int n = Integer.parseInt(e);
                    output.offer(n);
                });
        return output;
    }

    private static ArrayDeque<Integer> createCastings(String[] input) {
        ArrayDeque<Integer> output = new ArrayDeque<>();
        Arrays.stream(input)
                .forEach(e -> {
                    int n = Integer.parseInt(e);
                    output.push(n);
                });
        return output;
    }
}
