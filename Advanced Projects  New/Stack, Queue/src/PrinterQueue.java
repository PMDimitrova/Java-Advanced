import java.util.ArrayDeque;
import java.util.Scanner;

//FIFO => ArrayDeque (offer, poll, peel) - queue

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("print")){
            if (input.equals("cancel") && queue.size()==0){
                System.out.println("Printer is on standby");
            }else if (input.equals("cancel") && queue.size()>0){
                System.out.println("Canceled " + queue.poll());
            }else{
                queue.offer(input);
            }
            input = scan.nextLine();
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
