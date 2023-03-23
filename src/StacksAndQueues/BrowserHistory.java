package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

//Write a program which takes 2 types of browser instructions:
//•	Normal navigation: a URL is set, given by a string
//•	The string "back" that sets the current URL to the last set URL
//After each instruction the program should print the current URL.
// If the back instruction can’t be executed, print
//"no previous URLs". The input ends with "Home" command, then simply you have to stop the program.
public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentPage = "";
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Home")) {
                break;
            }
            if (input.equals("back") && currentPage.length() == 0) {
                if (!stack.isEmpty()) {
                    currentPage = stack.peek();
                }
                System.out.println("no previous URLs");
            } else if (input.equals("back") && currentPage.length() != 0) {
                System.out.println(currentPage);
            } else {
                stack.push(input);
                System.out.println(input);
            }
        }
    }
}
