package JA04MultidimensionalArraysExercises;

/*
Write a program, which reads a string matrix from the console and performs certain operations with its elements. User input is provided in a similar way as in the problems above – first, you read the dimensions and then the data.
Your program should then receive commands in the format: "swap row1 col1 row2c col2" where row1, row2, col1, col2 are coordinates in the matrix. For a command to be valid, it should start with the "swap" keyword along with four valid coordinates (no more, no less). You should swap the values at the given coordinates (cell [row1, col1] with cell [row2, col2]) and print the matrix at each step (this you'll be able to check if the operation was performed correctly).
If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates entered or the given coordinates do not exist), print "Invalid input!" and move on to the next command. Your program should finish when the string "END" is entered.
 */

import java.util.Scanner;

public class X05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("\\s");
            for (int col = 0; col < cols; col++) {
                matrix[row] = currentRow;
            }
        }

        String commands = scanner.nextLine();

        while (!commands.equals("END")) {

            if (!validCommand(commands)) {
                System.out.println("Invalid input!");
            } else {
                String[] currentCommand = commands.split(" ");

                if (validMatrix(currentCommand, rows, cols)) {
                    int row1 = Integer.parseInt(currentCommand[1]);
                    int col1 = Integer.parseInt(currentCommand[2]);
                    int row2 = Integer.parseInt(currentCommand[3]);
                    int col2 = Integer.parseInt(currentCommand[4]);

                    String firstElement = matrix[row1][col1];
                    String secondElement = matrix[row2][col2];

                    matrix[row1][col1] = secondElement;
                    matrix[row2][col2] = firstElement;

                    printMatrix(matrix);
                }else{
                    System.out.println("Invalid input!");
                }
            }

            commands = scanner.nextLine();
        }
    }

    private static boolean validMatrix(String[] currentCommand, int rows, int cols) {
        int row1 = Integer.parseInt(currentCommand[1]);
        int col1 = Integer.parseInt(currentCommand[2]);
        int row2 = Integer.parseInt(currentCommand[3]);
        int col2 = Integer.parseInt(currentCommand[4]);

        if (row1 >= 0 && row1 < rows) {

            if (row2 >= 0 && row2 < rows) {

                if (col1 >= 0 && col1 < cols) {

                    if (col2 >= 0 && col2 < cols) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean validCommand(String commands) {
        String[] currentCommand = commands.split(" ");

        if (currentCommand.length == 5) {
            if (currentCommand[0].equals("swap")) {
                return true;
            }
        }

        return false;
    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}