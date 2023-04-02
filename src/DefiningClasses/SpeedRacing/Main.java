package DefiningClasses.SpeedRacing;

import DefiningClasses.CompanyRoster.Department;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//Your task is to implement a program that keeps track of cars and their fuel and supports methods for moving the cars.
// Define a class Car that keeps track of a car information Model, fuel amount, fuel cost for 1 kilometer and distance
// traveled. A Car Model is unique - there will never be 2 cars with the same model.
// On the first line of the input you will receive a number N - the number of cars you need to track, on each of the
// next N lines you will receive information for a car in the following format "<Model> <FuelAmount> <FuelCostFor1km>",
// all cars start at 0 kilometers traveled.
//
//After the N lines until the command "End" is received, you will receive commands in the following format
// "Drive <CarModel>  <amountOfKm>", implement a method in the Car class to calculate whether a car can move that
// distance or not. If it yes, the car fuel amount should be reduced by the amount of used fuel and its distance
// traveled should be increased by the amount of kilometers traveled, otherwise the car should not move
// (Its fuel amount and distance traveled should stay the same) and you should print on the console
// "Insufficient fuel for the drive". After the "End" command is received, print each car in order of appearing in
// input and its current fuel amount and distance traveled in the format "<Model> <fuelAmount>  <distanceTraveled>",
// where the fuel amount should be printed to two decimal places after the separator.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> myCars = new TreeMap<>();
        while (nCars > 0){
            String[] tokens = scanner.nextLine().split(" ");
            Car current = new Car();
            current.setModel(tokens[0]);
            current.setFuelAmount(Double.parseDouble(tokens[1]));
            current.setFuelCostFor1km(Double.parseDouble(tokens[2]));
            myCars.put(tokens[0], current);
            nCars--;
        }
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("End")){
            Car current = myCars.get(command[1]);
            if(current.canMove(Integer.parseInt(command[2]))){
                double neededFuel = current.getFuelCostFor1km() * Integer.parseInt(command[2]);
                current.setFuelAmount(current.getFuelAmount() - neededFuel);
                current.setDistanceTravelled(current.getDistanceTravelled() + Integer.parseInt(command[2]));
            }else{
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine().split(" ");
        }
        for (Map.Entry<String, Car> entry : myCars.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
