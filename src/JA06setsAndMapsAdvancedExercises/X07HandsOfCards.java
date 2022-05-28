package JA06setsAndMapsAdvancedExercises;

import java.util.*;

/*
You are given a sequence of people and for every person what cards he draws from the deck. The input will be separate lines in the format:
"{personName}: {PT, PT, PT,… PT}"
Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type. The input ends when a "JOKER" is drawn. The name can contain any ASCII symbol except ":". The input will always be valid and in the format described, there is no need to check it.
A single person cannot have more than one card with the same power and type, if he draws such a card he discards it. The people are playing with multiple decks. Each card has a value that is calculated by the power multiplied by the type. Powers 2 to 10 have the same value and J to A are 11 to 14. Types are mapped to multipliers the following way (S -> 4, H-> 3, D -> 2, C -> 1).
Finally print out the total value each player has in his hand in the format:
"{personName}: {value}"

 */
public class X07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Set<String>> map = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] buff = input.split(": ");
            String name = buff[0];
            String[] cards = buff[1].split(", ");

            map.putIfAbsent(name, new HashSet<>());

            for (String card : cards) {
                map.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = calculatePoints(cards);
            System.out.printf("%s: %d%n", name, points);
        }
    }

    private static int calculatePoints(Set<String> cards) {
        int points = 0;

        for (String card : cards) {
            char color = card.charAt(card.length() - 1);
            String power = card.substring(0, card.length() - 1);
            int currentPoints = getColor(color) * getPower(power);
            points += currentPoints;
        }

        return points;
    }

    private static int getPower(String power) {
        switch (power) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(power);
        }
    }

    private static int getColor(char color) {
        switch (color) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 0;
        }
    }
}
