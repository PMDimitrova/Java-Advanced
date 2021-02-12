package SantasFactory;

import java.util.*;
import java.util.stream.Collectors;

//last material - lifo - stack - push/pop/peek
//first magic level - fifo - queue - offer/poll/peek

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputMaterials = scan.nextLine().split("\\s+");
        String[] inputMagicLvl = scan.nextLine().split("\\s+");

        Map<String, Integer> producedGoods = new TreeMap<>();

        ArrayDeque<Integer> materials = fillArrayDeque(inputMaterials, "stack");
        ArrayDeque<Integer> magicLevels = fillArrayDeque(inputMagicLvl, "queue");

        while (!materials.isEmpty() && !magicLevels.isEmpty()) {
            int material = materials.peek();
            int magicLvl = magicLevels.peek();
            int product = magicLvl * material;

            if (product < 0) {
                product = magicLvl + material;
                materials.pop();
                magicLevels.poll();
                materials.push(product);

            } else if (product == 0) {
                if (material == 0 && magicLvl == 0) {
                    materials.pop();
                    magicLevels.poll();
                } else if (material == 0) {
                    materials.pop();
                } else {
                    magicLevels.poll();
                }

            } else {
                boolean isSomethingProduced = false;
                switch (product) {
                    case 150:
                        producedGoods.putIfAbsent("Doll", 0);
                        producedGoods.put("Doll", producedGoods.get("Doll") +1);
                        isSomethingProduced = true;
                        break;
                    case 250:
                        producedGoods.putIfAbsent("Wooden train", 0);
                        producedGoods.put("Wooden train", producedGoods.get("Wooden train") +1);
                        isSomethingProduced = true;
                        break;
                    case 300:
                        producedGoods.putIfAbsent("Teddy bear", 0);
                        producedGoods.put("Teddy bear", producedGoods.get("Teddy bear") +1);
                        isSomethingProduced = true;
                        break;
                    case 400:
                        producedGoods.putIfAbsent("Bicycle", 0);
                        producedGoods.put("Bicycle", producedGoods.get("Bicycle") +1);
                        isSomethingProduced = true;
                        break;
                }
                //last material - lifo - stack - push/pop/peek
                //first magic level - fifo - queue - offer/poll/peek

                magicLevels.poll();
                if (isSomethingProduced){
                    materials.pop();
                }else{
                    int newMaterial = materials.pop() +15;
                    materials.push(newMaterial);
                }
            }
        }

        if ((producedGoods.containsKey("Doll") && producedGoods.containsKey("Wooden train"))
                || (producedGoods.containsKey("Teddy bear")) && (producedGoods.containsKey("Bicycle"))){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else{
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()){
            System.out.print("Materials left: ");
            System.out.println(materials.toString().replaceAll("[\\[\\]]", ""));

        }

        if (!magicLevels.isEmpty()){
            System.out.print("Magic left: ");
            System.out.println(magicLevels.toString().replaceAll("[\\[\\]]", ""));

        }

        producedGoods.entrySet().stream()
                .forEach(toy->{
                    System.out.print(toy.getKey() + ": " + toy.getValue());
                    System.out.println();
                });

    }

    private static ArrayDeque<Integer> fillArrayDeque(String[] input, String type) {
        ArrayDeque<Integer> output = new ArrayDeque<>();
        Arrays.stream(input).forEach(str -> {
            int num = Integer.parseInt(str);
            if (type.equals("queue")) {
                output.offer(num);
            } else {
                output.push(num);
            }
        });
        return output;
    }
}
