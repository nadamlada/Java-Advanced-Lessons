package JA01StacksAndQueuesLab;

/*
Create a simple program that can convert a decimal number to its binary representation. Implement an elegant solution using a Stack.
Print the binary representation back at the terminal.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class L03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //в двоична бройна система нулата е също нула

        if (decimal == 0) {
            System.out.println(0);
        } else {

            while (decimal != 0) {
                //докато остатъка от делнето не е нула
                int leftover = decimal % 2;
                stack.push(leftover);
                decimal = decimal / 2;
            }
        }

//        int stackSize = stack.size();
//        for (int i = 0; i < stackSize; i++) {
//            System.out.print(stack.pop());
//        }

        // stack.iter
        for (Integer integer : stack) {
            System.out.print(integer);
        }
    }
}
