package SetsAndMapsAdvanced;
//Write a program that:
//•	Records car number for every car that enter in the parking lot
//•	Removes car number when the car go out
//Input
//The input will be string in format [direction, carNumber]
//The input ends with string "END"
//Output
//Print the output with all car numbers which are in parking lot
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> cars = new LinkedHashSet<>();
        while(true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            String[] reminder = input.split(", ");
            if (reminder[0].equals("IN")) {
                cars.add(reminder[1]);
            }
            else {
                cars.remove(reminder[1]);
            }
        }
        if(!cars.isEmpty()) {
            for (String c : cars ) {
                System.out.println(c);
            }
        }else{
            System.out.println("Parking Lot is Empty");
        }


    }
}
