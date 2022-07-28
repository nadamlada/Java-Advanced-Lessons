package JA17ExamPreparation.EX01JavaAdvancedRetakeExam_13April2022;

/*
You have forged many swords, so now you start selling them. There are lots of customers who want to buy your blades, but you do not want to bargain for every single sword and decide to sell them to the king. The king sends an army officer to pick swords for his army. Your armory is huge, so you need to guide the army officer though.
You will be given an integer n for the size of the armory with a square shape. On the next n lines, you will receive the rows of the armory. The army officer will be placed in a random position, marked with the letter 'A'. On random positions, there will be swords, marked with a single digit (the price of the sword). There may also be mirrors, the count will be either 0 or 2 and they are marked with the letter - 'M'. All of the empty positions will be marked with '-'.
Each turn, you will tell the army officer which direction he should move. Move commands will be: "up", "down", "left", "right". If the army officer moves to a sword, he buys the sword for a price equal to the digit there and the sword disappears. If the army officer moves to a mirror, he teleports on the position of the other mirror, and then both mirrors disappear. If you guide the army officer out of the armory, he leaves with the swords that he has bought. In advance, you negotiate with the king, that he'll buy at least 65 gold coins worth of blades.
The program ends when the army officer buys blades for at least 65 gold coins, or you guide him out of the armory.
Input
•	On the first line, you are given the integer n – the size of the matrix (armory).
•	The next n lines hold the values for every row.
•	On each of the next lines, you will get a move command.
Output
•	On the first line:
o	If the army officer leaves the armory, print: "I do not need more swords!"
o	If the army officer fulfills the initial deal, print: "Very nice swords, I will come back for more!"
•	On the second line print the profit you’ve made: "The king paid {amount} gold coins."
•	At the end print the final state of the matrix (armory).
Constraints
•	The size of the square matrix (armory) will be between [2…10].
•	There will always be 0 or 2 mirrors, marked with the letter - 'M'.
•	The army officer’s position will be marked as 'A'.
•	There will be always two output scenarios: the army officer leaves or bays swords worth at least 65 gold coins.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EX02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = rows;
        char[][] matrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[row] = currentRow;
        }

        int myRow = -1;
        int myCol = -1;

        Map<Integer, Integer> mirrors = new HashMap<>();

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == 'A') {
                    myRow = row;
                    myCol = col;
                }

                if (matrix[row][col] == 'M') {
                    mirrors.put(row, col);
                }
            }
        }

        int paid = 0;
        boolean leaves = false;

        while (paid < 65) {
            String command = scanner.nextLine();
            matrix[myRow][myCol] = '-';

            switch (command) {
                case "up":
                    myRow--;
                    break;
                case "down":
                    myRow++;
                    break;
                case "left":
                    myCol--;
                    break;
                case "right":
                    myCol++;
                    break;
            }

            if (myCol < 0 || myCol >= cols || myRow < 0 || myRow >= rows) {
                leaves = true;
                break;
            }

            if (Character.isDigit(matrix[myRow][myCol])) {
                //sword
                int price = Integer.parseInt(matrix[myRow][myCol] + "");
                paid += price;
                matrix[myRow][myCol] = 'A';
            }

            if (matrix[myRow][myCol] == 'M') {
                matrix[myRow][myCol] = '-';
                mirrors.remove(myRow, myCol);

                for (Map.Entry<Integer, Integer> entry : mirrors.entrySet()) {
                    myRow = entry.getKey();
                    myCol = entry.getValue();
                }

                matrix[myRow][myCol] = '-';
            }
        }

        if (leaves) {
            System.out.println("I do not need more swords!");
        } else {
            // TODO: 20.06.2022
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", paid);

        print(matrix);

    }

    private static void print(char[][] matrix) {

        for (char[] chars : matrix) {

            for (char c : chars) {
                System.out.print(c);
            }

            System.out.println();
        }
    }
}