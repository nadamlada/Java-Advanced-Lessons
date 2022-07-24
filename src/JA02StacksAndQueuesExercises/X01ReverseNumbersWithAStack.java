package JA02StacksAndQueuesExercises;

/*
Write a program that reads N integers from the console and reverses them using a stack. Use the ArrayDeque<Integer> class. Just put the input numbers in the stack and pop them.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class X01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i : input) {
            stack.push(i);
        }

        //while(!stack.isEmpty())
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}
