package ShedulingNEW;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//tasks - lifo - stack - push.pop.peek
//threads - fifo - queue - offer.poll.peek

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputTasks = scan.nextLine().split(", ");
        String[] inputThreads = scan.nextLine().split("\\s+");

        int killIt = Integer.parseInt(scan.nextLine());
        boolean isTaskKilled = false;
        int killedByThread = -1;

        ArrayDeque<Integer> tasksStack= fillTheArrayDeque(inputTasks, "stack");
        ArrayDeque<Integer> threadsQueue = fillTheArrayDeque(inputThreads, "queue");

        while (!isTaskKilled){
            int task = tasksStack.peek();
            int thread = threadsQueue.peek();

            if (task == killIt){
                isTaskKilled = true;
                killedByThread = thread;
                break;      //?
            }else{
               if (thread>=task){
                   tasksStack.pop();
                   threadsQueue.poll();
               }else{
                   threadsQueue.poll();
               }
            }

//
//            if (thread>=task){
//                tasksStack.pop();
//            }
//            currThread = threadsQueue.poll();
//            if (task == killIt){
//                isTaskKilled = true;
//                threadsQueue.offer(currThread);
//            }

        }

        System.out.printf("Thread with value %d killed task %d%n", killedByThread, killIt);

        while (!threadsQueue.isEmpty()){
            System.out.print(threadsQueue.poll() + " ");
        }

//        List<Integer> output = new LinkedList<>();
//        while(!threadsQueue.isEmpty()){
//            output.add(0, threadsQueue.poll());
//        }
//        if (output.size()>0){
//            for (int i = 0; i < output.size(); i++) {
//                System.out.print(output.get(i) + " ");
//            }
//        }


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
