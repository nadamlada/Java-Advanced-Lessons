package JAMultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads a rectangular integer matrix of size N x M and finds in it the square 3 x 3 that has a maximal sum of its elements.
Input
•	On the first line, you will receive the rows N and columns M.
•	On the next N lines, you will receive each row with its elements.
Print the elements of the 3 x 3 square as a matrix, along with their sum. See the format of the output below.

 */
public class X04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }

        //след старт индекса остават винаги две колони и два реда до края,
        // защото вече са калкулирани и няма пълна матрица за следващи

        int maxSum = Integer.MIN_VALUE;

        int startIndexRow = -1;
        int startIndexCol = -1;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startIndexRow = row;
                    startIndexCol = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);

        for (int row = startIndexRow; row < startIndexRow + 3; row++) {
            for (int col = startIndexCol; col < startIndexCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
