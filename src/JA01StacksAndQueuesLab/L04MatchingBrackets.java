package JA01StacksAndQueuesLab;

/*
We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
Print the result back at the terminal.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class L04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        ArrayDeque<Integer> openIndexes = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (current == '(') {
                openIndexes.push(i);
            } else if (current == ')') {
                int lastOpenedIndex = openIndexes.pop();

                String matchingBrackets = expression.substring(lastOpenedIndex, i + 1);
                System.out.println(matchingBrackets);
            }
        }
    }
}
