import java.util.ArrayDeque;
import java.util.Scanner;

//LIFO => ArrayDeque (push, pop, peek) - stack
//FIFO => ArrayDeque (offer, poll, peel) - queue


public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input  = scan.nextLine();

        ArrayDeque<String> stackSites = new ArrayDeque<>();

        while (!input.equals("Home")){
            if (!input.equals("back")){
                stackSites.push(input);
                System.out.println(stackSites.peek());
            }else if(input.equals("back") && stackSites.size()>1){
                stackSites.pop();
                System.out.println(stackSites.peek());
            }else{
                System.out.println("no previous URLs");
            }

            input = scan.nextLine();
        }


    }
}

