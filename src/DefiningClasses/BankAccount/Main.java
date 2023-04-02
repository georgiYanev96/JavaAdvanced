package DefiningClasses.BankAccount;


import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(" ");
        Map<Integer, BankAccount> myAccList = new LinkedHashMap();
        int counter = 1;
        while (!command[0].equals("End")) {
            switch (command[0]) {
                case "Create": {
                    BankAccount current = new BankAccount();
                    myAccList.put(counter, current);
                    System.out.printf("Account ID%d created%n", counter);
                    counter++;
                    break;
                }
                case "Deposit": {
                    if (myAccList.containsKey(Integer.parseInt(command[1]))) {
                        myAccList.get(Integer.valueOf(command[1])).deposit(Double.parseDouble(command[2]));
                        System.out.printf("Deposited %.2f to ID%d%n", Double.parseDouble(command[2]), Integer.parseInt(command[1]));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                }
                case "SetInterest": {
                    myAccList.get(1).setInterestRate(Double.parseDouble(command[1]));
                    break;
                }
                case "GetInterest": {
                    if (myAccList.containsKey(Integer.parseInt(command[1]))) {
                        System.out.println(myAccList.get(Integer.valueOf(command[1])).getInterest(Integer.parseInt(command[2])));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                }
            }
            command = scanner.nextLine().split(" ");
        }
    }
}
