package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

//Extend "Browser History" with a "forward" instruction which visits URLs that were navigated away from by "back"
//Each forward instruction visits the next most-recent such URL.
//If a normal navigation happens, all potential forward URLs are removed until a new back instruction is given
//If the forward instruction can’t be executed, print
//"no next URLs".
public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> stackURLs = new ArrayDeque<>();
        ArrayDeque<String> forwardsQueue = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stackURLs.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    String currentURL = stackURLs.pop();
                    forwardsQueue.push(currentURL);
                    System.out.println(stackURLs.peek());
                }
            } else if (input.equals("forward")) {
                if (forwardsQueue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String currentForward = forwardsQueue.pop();
                    System.out.println(currentForward);
                    stackURLs.push(currentForward);
                }
            } else {
                stackURLs.push(input);
                System.out.println(input);
                forwardsQueue.clear();
            }
            input = scanner.nextLine();
        }
    }
}

