package JA03MultidimensionalArraysLab;

/*
Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element. For better code reusability, you could do the comparison in a method, which returns true if they are equal and false if not.
Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in the matrix and C – the number of columns – followed by R lines containing the C numbers, separated by spaces (each line will have an equal amount of numbers.
The matrices will have at most 10 rows and at most 10 columns.
Print "equal" if the matrices match, and "not equal" if they don’t match.
 */

import java.util.Arrays;
import java.util.Scanner;

public class L01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowCol1 = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        int rows1 = rowCol1[0];
        int cols1 = rowCol1[1];

        int[][] matrix1 = new int[rows1][cols1];

        for (int row = 0; row < rows1; row++) {
            int[] currentRow1 = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            matrix1[row] = currentRow1;
        }

        int[] rowCol2 = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int rows2 = rowCol2[0];
        int cols2 = rowCol2[1];

        if ((rows1 != rows2) || (cols1 != cols2)) {
            System.out.println("not equal");
            return;
        }

        int[][] matrix2 = new int[rows2][cols2];

        for (int row = 0; row < rows2; row++) {
            int[] currentRow2 = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            matrix2[row] = currentRow2;
        }

        for (int row = 0; row < rows1; row++) {
            for (int col = 0; col < cols1; col++) {
                if (matrix1[row][col] != matrix2[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }
}
