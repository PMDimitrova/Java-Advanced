package Scheduling;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//tasks - lifo - stack - push.pop.peek
//treads - fifo - queue - offer.poll.peek

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputTasks = scan.nextLine().split(", ");
        String[] inputThreads = scan.nextLine().split("\\s+");
        int taskToKill = Integer.parseInt(scan.nextLine()); //stop the work of the CPU as soon as you get to this task

        ArrayDeque<Integer> tasksStack = fillTheArrayDeque(inputTasks, "stack");
        ArrayDeque<Integer> threadsQueue = fillTheArrayDeque(inputThreads, "queue");

        boolean taskIsKilled = false;
        int threadThatKilled = -1;

        while (!taskIsKilled) {
            int taskCurrent = tasksStack.pop();
            int threadCurrent = threadsQueue.poll();

            if (threadCurrent < taskCurrent) {
                tasksStack.push(taskCurrent);
            }
            if (taskToKill == taskCurrent) {
                taskIsKilled = true;
                threadThatKilled = threadCurrent;
                threadsQueue.offer(threadCurrent);
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", threadThatKilled, taskToKill);

        List<Integer> output = new ArrayList<>();

        while (!threadsQueue.isEmpty()){
            output.add(0, threadsQueue.poll());
        }
        output.stream().forEach(num ->{
            System.out.print(num + " ");
        });
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
