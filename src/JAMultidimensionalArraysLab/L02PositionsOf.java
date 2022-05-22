package JAMultidimensionalArraysLab;
/*
Write a program that reads a matrix of integers from the console, then a number, and prints all the positions at which that number appears in the matrix.
The matrix definition on the console will contain a line with two positive integer numbers R and C – the number of rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces), representing each row of the matrix.
The number you will need to find the positions of will be entered on a single line, after the matrix.
You should print each position on a single line – first print the row, then the column at which the number appears.
If the number does not appear in the matrix, print "not found".

 */

import java.util.Arrays;
import java.util.Scanner;

public class L02PositionsOf {
    public static void in(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsCols = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] matrixRow = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = matrixRow;
        }

        boolean isFound = false;
        int searched = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == searched) {
                    isFound = true;
                    System.out.print(row + " " + col);
                    System.out.println();
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}
