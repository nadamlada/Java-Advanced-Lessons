package JA01StacksAndQueuesLab;

/*
Rework the previous problem so that a child is removed only on a composite (not prime) cycle (cycles start from 1).
If a cycle is prime, just print the child's name.
As before, print the name of the child that is left last.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class NEL7MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> kids = new ArrayDeque<>();

        int rotation = Integer.parseInt(scanner.nextLine());

        for (String s : input) {
            kids.add(s);
        }

        int counter = 0;

        while (kids.size() != 1) {
            counter++;

            if (counter == rotation) {

                if (primeCycle(counter)) {
                    System.out.printf("Removed %s%n", kids.peek());
                    kids.poll();
                    counter = 0;
                } else {
                    System.out.printf("Prime %s%n", kids.peek());

                }
            } else {
                String currentKid = kids.peek();
                kids.poll();
                kids.offer(currentKid);
            }
        }

        System.out.printf("Last is %s", kids.peek());
    }

    private static boolean primeCycle(int number) {

        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

/*
boolean prime = true;

        for (int z = 2; z <= n - 1; z++) {
            if (n % z == 0) {
                prime = false;
                break;
            }
        } if (prime) {
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }

 */




/* от презентацията
int cycle = 1;
while (queue.size() > 1) {
  for (int i = 1; i < n; i++)
    queue.offer(queue.poll());

  if (isPrime(cycle))
    System.out.println("Prime " + queue.peek());
  else
    System.out.println("Removed " + queue.poll());

  cycle++;
}
System.out.println("Last is " + queue.poll());

 */
