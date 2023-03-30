package SetsAndMapsAdvanced;
//Write a program that counts the occurrence of real numbers.
//The input is a single line with real numbers separated by spaces.
//Print the numbers in the order of appearance.
//All numbers must be formatted to one digit after the decimal point.

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> myMap = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            if(!myMap.containsKey(input[i])){
                myMap.put(input[i], 1);
            }else{
                myMap.put(input[i], myMap.get(input[i]) + 1);
            }
        }
        for (Double key : myMap.keySet()) {
            System.out.println(key + " -> " + myMap.get(key));
        }

    }
}
