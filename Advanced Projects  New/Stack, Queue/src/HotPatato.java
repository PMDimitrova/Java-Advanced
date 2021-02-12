import java.util.ArrayDeque;
import java.util.Scanner;

//FIFO => ArrayDeque (offer, poll, peel) - queue

public class HotPatato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int count = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String kid = input[i];
            kids.offer(kid);
        }

        while (!(kids.size()==1)) {
            for (int i = 0; i < count-1; i++) {
                String survivorKid = kids.poll();
                kids.offer(survivorKid);
            }
            System.out.println("Removed " + kids.poll());
        }
        System.out.println("Last is " + kids.poll());
    }
}
