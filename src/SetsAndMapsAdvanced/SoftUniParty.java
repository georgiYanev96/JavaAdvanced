package SetsAndMapsAdvanced;
//There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular.
//When guest comes, you have to check if he/she exist in any of two reservation lists.
//All reservation numbers will be with 8 chars.
//All VIP numbers start with digit.
//There will be 2 command lines. First is "PARTY" - party is on and guests start coming.
//Second is "END" - then party is over, and no more guest will come.
//Output shows all guests, who didn't come to the party (VIP must be first).
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();
        String guestId = scanner.nextLine();

        while (!guestId.equals("PARTY")) {
            if (Character.isDigit(guestId.charAt(0))) {
                vip.add(guestId);
            } else {
                regular.add(guestId);
            }
            guestId = scanner.nextLine();
        }

        while(true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            if(vip.contains(input)){
                vip.remove(input);
            }else if(regular.contains(input)){
                regular.remove(input);
            }
        }
        int total = vip.size() + regular.size();
        System.out.println(total);
        if(!vip.isEmpty()) {
            for (String guest : vip ) {
                System.out.println(guest);
            }
        }
        if(!regular.isEmpty()) {
            for (String guest : regular) {
                System.out.println(guest);
            }
        }


    }
}
