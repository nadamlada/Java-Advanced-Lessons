package JAMultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads a matrix from the console and prints:
•	The count of rows
•	The count of columns
•	The sum of all matrix’s elements
On the first line, you will get the dimensions of the matrix in the format "{rows, columns}". On the next lines, you will get the elements for each row separated by a comma.
 */
public class L04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixSize[0];
        int cols = matrixSize[1];
        int[][] matrix = new int[rows][cols];

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = rowOfMatrix[col];
                sum += matrix[row][col];

            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

        /*
        //read the matrix
        for (int row = 0; row < rows; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = rowOfMatrix[col];

            }
        }

        //sum elements of matrix
        sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        */
    }
}
