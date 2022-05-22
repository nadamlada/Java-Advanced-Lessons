package JAStacksAndQueuesExercises_;
/*
You will be given an integer N representing the number of elements to push into the stack, an integer S representing the number of elements to pop from the stack, and finally an integer X, an element that you should check whether is present in the stack. If it is, print "true" on the console. If it’s not, print the smallest element currently present in the stack.
Input
•	On the first line, you will be given N, S, and X separated by a single space.
•	On the next line, you will be given a line of numbers separated by one or more white spaces.
Output
•	On a single line print, either "true" if X is present in the stack, otherwise print the smallest element in the stack.
•	If the stack is empty – print 0.

 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class X02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int elementsToPush = input[0];
        int elementsToPop = input[1];
        int existsOrNot = input[2];

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < elementsToPush; i++) {
            //или без да правя втори масив -> stack.push(Scanner.nextInt());
            stack.push(data[i]);
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if(stack.isEmpty()){
            System.out.println("0");
            return;
        }

        if(stack.contains(existsOrNot)){
            System.out.println("true");
        }else{
            System.out.println(Collections.min(stack));
        }
    }
}
