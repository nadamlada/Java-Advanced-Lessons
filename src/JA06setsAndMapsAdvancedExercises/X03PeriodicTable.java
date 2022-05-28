package JA06setsAndMapsAdvancedExercises;

/*
You are given an n number of chemical compounds. You need to keep track of all chemical elements used in the compounds and at the end print all unique ones in ascending order:
 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class X03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        Set<String> set = new TreeSet<>();

        while (input-- > 0) {
            String[] elements = scanner.nextLine().split(" ");
            for (String element : elements) {
                set.add(element);
            }
        }

        String print = String.join(" ", set);
        System.out.println(print);
    }
}
