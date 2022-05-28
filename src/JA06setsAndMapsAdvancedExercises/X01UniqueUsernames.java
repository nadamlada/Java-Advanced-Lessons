package JA06setsAndMapsAdvancedExercises;
/*
Write a simple program that reads from the console a sequence of usernames and keeps a collection with only the unique ones. Print the collection on the console in order of insertion:
 */
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class X01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        Set<String> set = new LinkedHashSet<>();

        while (input-- > 0) {
            String text = scanner.nextLine();
            set.add(text);
        }

        //set.forEach(e -> System.out.println(e));
        for (String s : set) {
            System.out.println(s);
        }
    }
}
