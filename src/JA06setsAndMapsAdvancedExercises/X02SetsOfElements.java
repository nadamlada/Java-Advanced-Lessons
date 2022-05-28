package JA06setsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
On the first line, you are given the length of two sets N and M. On the next N + M lines there are N numbers, that are in the first set and M numbers that are in the second one. Find all non-repeating element that appears in both of them, and print them in the same order at the console:
Set with length N = 4: {1, 3, 5, 7}
Set with length M = 3: {3, 4, 5}
Set that contains all repeating elements -> {3, 5}

 */
public class X02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int firstLength = Integer.parseInt(input[0]);
        int secondLength = Integer.parseInt(input[1]);

        Set<String> set1 = new LinkedHashSet<>();
        for (int i = 0; i < firstLength; i++) {
            set1.add(scanner.nextLine());
        }

        Set<String> set2 = new LinkedHashSet<>();
        for (int i = 0; i < firstLength; i++) {
            set2.add(scanner.nextLine());
        }

        //изтрива тези, които се повтарят
        set1.retainAll(set2);

        System.out.println(String.join(" ",set1));
    }
}
