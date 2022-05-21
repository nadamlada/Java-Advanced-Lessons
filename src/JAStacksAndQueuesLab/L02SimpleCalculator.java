package JAStacksAndQueuesLab;
/*
Create a simple calculator that can evaluate simple expressions that will not hold any operator different from addition and subtraction. There will not be parentheses or operator precedence.
Solve the problem using a Stack.

 */

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class L02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> tokens = new ArrayDeque<>();
        Collections.addAll(tokens, input);

        while (tokens.size() > 1) {
            int firstNumber = Integer.parseInt(tokens.pop());
            String operator = tokens.pop();
            int secondNumber = Integer.parseInt(tokens.pop());
            int result = 0;

            if (operator.equals("+")) {
                //sum
                result = firstNumber + secondNumber;
            } else {
                //substract
                result = firstNumber - secondNumber;
            }
            tokens.push(result + "");
            //tokens.push(String.valueOf(result));

        }
        System.out.println(tokens.peek());
    }
}
