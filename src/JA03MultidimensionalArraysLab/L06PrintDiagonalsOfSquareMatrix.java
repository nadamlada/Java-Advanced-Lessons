package JA03MultidimensionalArraysLab;

/*
Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square. On the first line, you read a single integer N the matrix size. Then on each line N elements. The first diagonal should always start with the element at the first row and col, the second diagonal should start with the element at the last row and first col.
 */

import java.util.Arrays;
import java.util.Scanner;

public class L06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int[] current = Arrays.stream(scanner.nextLine().split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = current;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println();

        for (int j = 0; j < n; j++) {
            //30 21 12 03
            System.out.print(matrix[n -1- j][j] + " ");
        }
    }
}
