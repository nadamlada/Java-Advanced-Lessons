package JA05SetsAndMapsAdvancedLab;

/*
Write a program that:
•	Reads 20 numbers for both players, separated with " " (single space).
o	Every player can hold unique numbers.
Each Round both players get the top number from their deck. The player with the bigger number gets both numbers and adds them to the bottom of his sequence.
The game ends after 50 rounds or if any player loses all of his numbers.
Input
•	Numbers – Integer
Output
•	Output must be "First player win!", "Second player win!" or "Draw!".

Hints
•	Use Iterator<E> and next() for finding the top number in decks.
•	Think where to check if any player is without cards.
•	When you find the top number, be sure to remove it immediately.
 */

import java.util.*;
import java.util.stream.Collectors;

public class L03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> firstPlayer = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Set<Integer> firstPlayerSet = new LinkedHashSet<>(firstPlayer);

        String input2 = scanner.nextLine();
        List<Integer> secondPlayer = Arrays.stream(input2.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Set<Integer> secondPlayerSet = new LinkedHashSet<>(secondPlayer);

        for (int games = 0; games < 50; games++) {

            if (firstPlayerSet.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }

            if (secondPlayerSet.isEmpty()) {
                System.out.println("First player win!");
                return;
            }

            int firstPlayerCard = firstCard(firstPlayerSet);
            int secondPlayerCard = firstCard(secondPlayerSet);

            firstPlayerSet.remove(firstPlayerCard);
            secondPlayerSet.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerSet.add(firstPlayerCard);
                firstPlayerSet.add(secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard) {
                secondPlayerSet.add(firstPlayerCard);
                secondPlayerSet.add(secondPlayerCard);
            }
        }

        if (firstPlayerSet.size() > secondPlayerSet.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerSet.size() < secondPlayerSet.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static int firstCard(Set<Integer> playerSet) {

        for (int card : playerSet) {
            return card;
        }

        return 0;
    }
}
