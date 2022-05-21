package JAStacksAndQueuesLab;
/*
Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts with the first kid. Every nth toss the child left with the potato leaves the game. When a kid leaves the game, it passes the potato forward. This continues repeating until there is only one kid left.
Create a program that simulates the game of Hot Potato.  Print every kid that is removed from the circle. In the end, print the kid that is left last.

 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class L06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split(" ");
        int numberOfKids = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        for (int i = 0; i < kids.length; i++) {
            //добавя в опашката
            kidsQueue.offer(kids[i]);
        }

        while (kidsQueue.size() != 1) {
            for (int i = 1; i < numberOfKids; i++) {
                //премахваме
                String currentKid = kidsQueue.poll();
                //добавяме най-накрая
                kidsQueue.offer(currentKid);

            }
            //премахваме го
            String kidToRemove = kidsQueue.poll();
            System.out.println("Removed " + kidToRemove);

        }
        String lastKid = kidsQueue.peek();
        System.out.printf("Last is %s", lastKid);

    }
}
