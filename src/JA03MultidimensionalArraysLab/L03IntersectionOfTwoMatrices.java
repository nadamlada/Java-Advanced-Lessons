package JA03MultidimensionalArraysLab;

/*
Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints the third matrix C[][] which is filled with the intersecting elements of A and B, otherwise set the element to '*'. On the first two lines, you receive M and N, then on 2 * M lines N characters – the matrices elements.
The matrix elements may be any ASCII char except '*'.
 */

import java.util.Scanner;

public class L03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentChars = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = currentChars[col].charAt(0);
            }
        }
        char[][] secondMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentChars = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = currentChars[col].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
