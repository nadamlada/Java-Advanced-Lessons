package JAStacksAndQueuesExercises;
/*
You will be given an integer N representing the number of elements to enqueue (add), an integer S representing the number of elements to dequeue (remove/poll) from the queue, and finally an integer X, an element that you should check whether is present in the queue. If it is - prints true on the console, if it is not - print the smallest element currently present in the queue.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class X04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commands = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int elementsToEnqueue = commands[0];
        int elementsToDequeue = commands[1];
        int existsOrNot = commands[2];

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < elementsToEnqueue; i++) {
            queue.offer(input[i]);
        }

        for (int i = 0; i < elementsToDequeue; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
            return;
        }

        if (queue.contains(existsOrNot)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
