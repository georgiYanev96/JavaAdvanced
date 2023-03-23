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
        String lastPage = "";
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Home")) {
                break;
            }
            if (input.equals("back") && lastPage.length() == 0) {
                if (!stack.isEmpty()) {
                    lastPage = stack.peek();
                }
                System.out.println("no previous URLs");
            } else if (input.equals("back") && lastPage.length() != 0) {
                System.out.println(lastPage);
            } else {
                stack.push(input);
                System.out.println(input);
            }
        }
    }
}
