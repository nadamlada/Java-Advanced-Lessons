package JA05SetsAndMapsAdvancedLab;

/*
There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular.
When a guest comes, you have to check if he/she exists in any of the two reservation lists. All reservation numbers will be with 8 chars. All VIP numbers start with a digit.
There will be 2 command lines:
•	First is "PARTY" - the party is on and guests start coming.
•	The second is "END" - then the party is over, and no more guests will come.
The output shows all guests, who didn't come to the party (VIP must be first).
 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class L02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> set = new TreeSet();

        while (!input.equals("PARTY")) {
            set.add(input);
            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        while (!input2.equals("END")) {
            set.remove(input2);
            input2 = scanner.nextLine();
        }

        System.out.println(set.size());
        System.out.println(String.join(System.lineSeparator(), set));
    }
}
