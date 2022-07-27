package JA04MultidimensionalArraysExercises;

/*
Filling a matrix in the regular way (top to bottom and left to right) is boring. Write two methods that fill a matrix of size N x N in two different patterns. Both patterns are described below:
 Hints
•	Make a different method for each pattern.
•	Make a method for printing the matrix.
 */

import java.util.Scanner;

public class X01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String typeRotation = input[1];

        int counter = 0;

        int[][] matrix = new int[size][size];

        if (typeRotation.equals("A")) {
            typeA(size, counter, matrix);

        } else if (typeRotation.equals("B")) {
            typeB(size, counter, matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {

        for (int[] rows : matrix) {

            for (int element : rows) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void typeB(int size, int counter, int[][] matrix) {

        for (int col = 0; col < size; col++) {

            if (col % 2 != 0) {

                for (int row = size - 1; row >= 0; row--) {
                    counter++;
                    matrix[row][col] = counter;
                }

            } else {

                for (int row = 0; row < size; row++) {
                    counter++;
                    matrix[row][col] = counter;
                }
            }
        }
    }

    private static void typeA(int size, int counter, int[][] matrix) {

        for (int col = 0; col < size; col++)

            for (int row = 0; row < size; row++) {
                counter++;
                matrix[row][col] = counter;
            }
    }
}
