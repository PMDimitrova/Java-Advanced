import java.util.ArrayDeque;
import java.util.Scanner;

//LIFO => ArrayDeque (push, pop, peek) - stack
//FIFO => ArrayDeque (offer, poll, peel) - queue


public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        ArrayDeque<String> stackSites = new ArrayDeque<>();
        ArrayDeque<String> queueBack = new ArrayDeque<>();

        String currentSite = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stackSites.size() == 0) {
                    System.out.println("no previous URLs");
                } else {
                    currentSite = stackSites.pop();
                    queueBack.offer(currentSite);
                    System.out.println(stackSites.peek());
                }
            } else if (input.equals("forward")) {
                if (queueBack.size() == 0) {
                    System.out.println("no next URLs");
                } else {
                    currentSite = queueBack.poll();
                    System.out.println(currentSite);
                    stackSites.push(currentSite);
                }
            } else {
                stackSites.push(input);
                System.out.println(stackSites.peek());
            }

            input = scan.nextLine();
        }


    }
}

