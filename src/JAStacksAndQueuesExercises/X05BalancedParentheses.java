package JAStacksAndQueuesExercises;
/*
Given a sequence consisting of parentheses, determine whether the expression is balanced. A sequence of parentheses is balanced if every open parenthesis can be paired uniquely with a closing parenthesis that occurs after the former. Also, the interval between them must be balanced.
You will be given three types of parentheses: (, {, and [.
{[()]} - This is a balanced parenthesis.
{[(])} - This is not a balanced parenthesis.
Input
•	Each input consists of a single line, the sequence of parentheses.
•	1 ≤ Length of sequence ≤ 1000.
•	Each character of the sequence will be one of the following: {, }, (, ), [, ].
Output
•	For each test case, print on a new line "YES" if the parentheses are balanced. Otherwise, print "NO".

 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class X05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> deque = new ArrayDeque<>();
        boolean areEquals = false;
        if (input.length() % 2 != 0) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                    deque.push(currentChar);
                } else {
                    if (deque.peek() == '(' && currentChar == ')') {
                        areEquals = true;
                        deque.pop();
                        continue;

                    } else if (deque.peek() == '[' && currentChar == ']') {
                        areEquals = true;
                        deque.pop();
                        continue;

                    } else if (deque.peek() == '{' && currentChar == '}') {
                        areEquals = true;
                        deque.pop();
                        continue;
                    } else {
                        System.out.println("NO");
                        break;
                    }
                }
            }
        }

        if (areEquals) {
            System.out.println("YES");
        }

    }
}
