//package JAMultidimensionalArraysLab;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///*
//Write a program that reads a matrix from the console. Then find the biggest sum of a 2x2 submatrix. Print the submatrix and its sum.
//On the first line, you will get the dimensions of the matrix in the format "{rows, columns}". On the next lines, you will get the elements for each row separated by a comma.
//
// */
//public class L05MaximumSumOf_2x2Submatrix {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] rowsCols = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
//        int rows = rowsCols[0];
//        int cols = rowsCols[1];
//
//        int[][] matrix = new int[rows][cols];
//        for (int row = 0; row < rows; row++) {
//            int[] current = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
//            matrix[row] = current;
//
//
//            int[][] smallMatrix = new int[2][2];
//
//            for (int smallRow = 0; smallRow < 2; smallRow++) {
//                for (int smallCol = 0; smallCol < 2; smallCol++) {
//
//                    smallMatrix[smallRow][smallCol] = matrix[row][col];
//
//                }
//            }
//        }
//
//
//    }
//
//}
//
