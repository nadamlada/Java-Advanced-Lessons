package JA05SetsAndMapsAdvancedLab;
/*
Read a list of integers and print the largest 3 of them. If there are less than 3, print all of them.
Hints
•	Read a list of integers.
•	Order the list using Stream API.

 */

import java.util.Arrays;
import java.util.Scanner;

public class X09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .sorted(
                        (left, right) -> right.compareTo(left)
                ).limit(3)

                //за печатане на нов ред
                //.forEach(System.out::println);

                .forEach(number -> System.out.print(number + " "));
    }
}