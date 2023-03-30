package SetsAndMapsAdvanced;

import java.util.*;

//Write a simple program that reads from the console a sequence of usernames and keeps a collection with only the unique ones.
//Print the collection on the console in order of insertion:
public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet();
        while (n > 0){
            String input = scanner.nextLine();
            if(!usernames.contains(input)){
                usernames.add(input);
            }

            n--;
        }
        while (!usernames.isEmpty()) {
            String currentUsername  = usernames.iterator().next();
            System.out.println(currentUsername);
            usernames.remove(currentUsername);
        }
    }
}
