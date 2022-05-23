package JAStacksAndQueuesExercises;
/*
You have an empty sequence, and you will be given N commands. Each command is one of the following types:
•	"1 X" - Push the element X into the stack.
•	"2" - Delete the element present at the top of the stack.
•	"3" - Print the maximum element in the stack.
Input
•	The first line of input contains an integer N, where 1 ≤ N ≤ 105.
•	The next N lines contain commands. All commands will be valid and in the format described.
•	The element X will be in the range 1 ≤ X ≤ 109.
•	The type of the command will be in the range 1 ≤ Type ≤ 3.
Output
•	For each command of type "3", print the maximum element in the stack on a new line.

 */

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class X03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < countCommands; i++) {

            String[] input = scanner.nextLine().split(" ");

            if (input.length == 1) {
                if (input[0].equals("2")) {
                    stack.pop();
                } else {
                    System.out.println(Collections.max(stack));
                }

            } else {
                int elementToPush = Integer.parseInt(input[1]);
                stack.push(elementToPush);
            }
        }
    }
}
