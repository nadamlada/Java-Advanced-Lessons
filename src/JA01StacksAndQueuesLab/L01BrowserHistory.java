package JA01StacksAndQueuesLab;
/*
Write a program, which takes 2 types of browser instructions:
•	Normal navigation: a URL is set, given by a string;
•	The string "back" sets the current URL to the last set URL
After each instruction, the program should print the current URL. If the back instruction can’t be executed, print
"no previous URLs". The input ends with the "Home" command and then simply you have to stop the program.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String input = scanner.nextLine();

        String currentUrl = "";
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                //back
                if (browserHistory.size() > 1) {
                    //премахваме
                    browserHistory.pop();
                    //връща
                    currentUrl = browserHistory.peek();
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                //url
                browserHistory.push(input);
                currentUrl = browserHistory.peek();
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }
    }
}
