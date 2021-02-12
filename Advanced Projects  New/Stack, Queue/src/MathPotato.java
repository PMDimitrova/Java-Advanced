import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int count = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();

        int cycleCount = 0;

        for (int i = 0; i < input.length; i++) {
            String kid = input[i];
            kids.offer(kid);
        }

        String survivorKid = "";

        while (!(kids.size()==1)) {
            cycleCount++;

            for (int i = 1; i < count; i++) {
                survivorKid = kids.poll();
                kids.offer(survivorKid);
            }
            if (cycleCount%2 == 0){
                System.out.println("Removed " + kids.poll());
            }else{
                System.out.println("Prime " + kids.peek());
            }
        }
        System.out.println("Last is " + kids.poll());
    }
}
