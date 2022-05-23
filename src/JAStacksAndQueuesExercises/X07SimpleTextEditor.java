package JAStacksAndQueuesExercises;
/*
You are given an empty text. Your task is to implement 4 types of commands related to manipulating the text:
•	"1 {string}" - appends [string] to the end of the text.
•	"2 {count}" - erases the last [count] elements from the text.
•	"3 {index}" - returns the element at position [index] from the text.
•	"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.
Input
•	The first line contains N, the number of operations, where 1 ≤ N ≤ 105.
•	Each of the following N lines contains the name of the operation, followed by the command argument, if any, separated by space in the following format "command argument".
•	The length of the text will not exceed 1000000.
•	All input characters are English letters.
•	It is guaranteed that the sequence of input operations is possible to perform.
Output
•	For each operation of type "3" print a single line with the returned character of that operation.

 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class X07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();

        //стек с история на командите
        ArrayDeque<String> commandsStack = new ArrayDeque<>();
        ArrayDeque<String> removedElementsStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String rawCommand = scanner.nextLine();
            String[] command = rawCommand.split(" ");
            switch (command[0]) {
                case "1":
                    commandsStack.push(rawCommand);
                    executeAdd(text, command[1]);
                    break;

                case "2":
                    commandsStack.push(rawCommand);
                    int countToDelete = Integer.parseInt(command[1]);
                    StringBuilder str = new StringBuilder();
                    for (int j = text.length()- countToDelete; j < text.length(); j++) {
                        str.append(text.charAt(j));
                    }
                    removedElementsStack.push(str.toString());
                    executeDelete(text, countToDelete);
                    break;

                case "3":
                    commandsStack.push(rawCommand);
                    int index = Integer.parseInt(command[1]);
                    System.out.printf("%s%n", text.charAt(index - 1));
                    break;

                case "4":
                    String[] lastCommand = commandsStack.pop().split(" ");
                    switch (lastCommand[0]) {
                        case "1":
                            //било е добавяне
                            int elementsToDelete = lastCommand[1].length();
                               executeDelete(text, elementsToDelete);
                            //сега премахваме
                            break;
                        case "2":
                            //било е премахване
                            String elementsToAddBack = removedElementsStack.pop();
                            executeAdd(text, elementsToAddBack);
                            //сега добавяме
                            break;
                    }

                    break;
            }
        }
    }

    private static void executeDelete(StringBuilder text, int countToDelete) {
        for (int i = 0; i < countToDelete; i++) {
            text.deleteCharAt(text.length() - 1);
        }
    }

    private static void executeAdd(StringBuilder text, String command) {
        text.append(command);
    }
}
