package JA01StacksAndQueuesLab;

/*
The printer queue is a simple way to control the order of files sent to a printer device. We know that a single printer can be shared between multiple devices. So to preserve the order of the files sent, we can use a queue.
Write a program, which takes filenames until the "print" command is received. Then as output print the filenames in the order of printing. Some of the tasks may be canceled if you receive "cancel" you have to remove the first file to be printed. If there is no current file to be printed print "Printer is on standby".
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class L05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> files = new ArrayDeque<>();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {

                if (files.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    //когато опашката не е празна
                    //премахмаве го
                    String firstFileInQueue = files.poll();
                    System.out.printf("Canceled %s%n", firstFileInQueue);
                }
            } else {
                //we have file
                // add in queue
                files.offer(input);
            }

            input = scanner.nextLine();
        }

        for (String file : files) {
            System.out.println(file);
        }
    }
}