package JA04MultidimensionalArraysExercises;

/*
Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).

Input
•	The first line holds a number n – the size of matrix.
•	The next n lines hold the values for every row – n numbers separated by a space.

Hints
•	Use a single loop i = [1 … n] to sum the diagonals.
•	The primary diagonal holds all cells {row, col} where row == col == i.
•	The secondary diagonal holds all cells {row, col} where row == i and col == n-1-i.
 */

import java.util.Arrays;
import java.util.Scanner;

public class X03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            int[] rowInput = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < size; col++) {
                matrix[row] = rowInput;
            }
        }

        int sumPrimaryDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            int currentIntersection1 = matrix[row][row];
            sumPrimaryDiagonal += currentIntersection1;
        }

        int sumSecondaryDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            int currentIntersection2 = matrix[row][matrix.length - 1 - row];
            sumSecondaryDiagonal += currentIntersection2;
        }

        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }
}

