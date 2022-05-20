package JAMultidimensionalArraysLab;
/*
You will be given the rows of a matrix. Then the matrix itself. Inside this matrix, there are mistaken values that need to be replaced you will receive the wrong value at the last line. Those values should be replaced with the sum of the nearest elements in the four directions up, down, left, and right, but only if they are valid values. In the end, you have to print the fixed measurements.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];
        int cols = 0;

        for (int row = 0; row < rows; row++) {
            String input = scanner.nextLine();
            String[] buffer = input.split(" ");
            cols = buffer.length;

            int[] currentRow = Arrays.stream(input.split("\\s")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }

        int[] searchedIndex = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        int searchedRow = searchedIndex[0];
        int searchedCol = searchedIndex[1];

        int searchedNum = matrix[searchedRow][searchedCol];
        int[][] blank = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == searchedNum) {
                    //на кой индекс съм в момента
                    //с кое число да се замени

                    int sumForReplacement = 0;
                    if (row > 0) {
                        int upElement = matrix[row - 1][col];
                        if (upElement != searchedNum) {
                            sumForReplacement += upElement;
                        }
                    }

                    if (row + 1 < rows) {
                        int downElement = matrix[row + 1][col];
                        if (downElement != searchedNum) {
                            sumForReplacement += downElement;
                        }
                    }

                    if (col + 1 < cols) {
                        int rightElement = matrix[row][col + 1];
                        if (rightElement != searchedNum) {
                            sumForReplacement += rightElement;
                        }
                    }

                    if (col > 0) {
                        int leftElement = matrix[row][col - 1];
                        if (leftElement != searchedNum) {
                            sumForReplacement += leftElement;
                        }
                    }

                    blank[row][col] = sumForReplacement;
                    sumForReplacement = 0;

                } else {
                    blank[row][col] = matrix[row][col];
                }
            }
        }

        for (int[] ints : blank) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}