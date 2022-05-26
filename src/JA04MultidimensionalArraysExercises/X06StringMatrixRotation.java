package JA04MultidimensionalArraysExercises;

/*
You are given a sequence of text lines. Assume these text lines form a matrix of characters (pad the missing positions with spaces to build a rectangular matrix). Write a program to rotate the matrix by 90, 180, 270, 360,… degrees. Print the result at the console as a sequence of strings after receiving the "END" command.
 Input
The input is read from the console:
•	The first line holds the command in the format "Rotate(X)" where X is the degrees of the requested rotation.
•	The next lines contain the lines of the matrix for rotation.
•	The input ends with the command "END".
The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
Print at the console the rotated matrix as a sequence of text lines.
Constraints
•	The rotation degree is a positive integer in the range [0…90000], where degrees are multiple of 90.
•	The number of matrix lines is in the range [1…1 000].
•	The matrix lines are strings of length 1 … 1 000.
•	Allowed working time: 200ms/16MB.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = scanner.nextLine();

        String input = scanner.nextLine();

        int maxLength = 0;          //cols
        List<String> list = new ArrayList<>();

        while (!input.equals("END")) {
            int currentLength = input.length();
            list.add(input);

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
            input = scanner.nextLine();
        }

        int rows = list.size();
        int cols = maxLength;

        //пълня масива с празни елементи до края на реда на матрицата
        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);
            while (current.length() != maxLength) {
                current = current + " ";
                list.set(i, current);
            }
        }

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String currentWord = list.get(row);

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currentWord.charAt(col);
            }
        }

        //търся ъгъла
        String rotateAngleBuff = rotation.split("\\(")[1];
        String rotateAngle = rotateAngleBuff.substring(0, rotateAngleBuff.length() - 1);
        int angle = Integer.parseInt(rotateAngle) % 360;

        // left -> right col++
        // right -> left col--
        // up -> row--
        // down -> row++

        switch (angle) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}

