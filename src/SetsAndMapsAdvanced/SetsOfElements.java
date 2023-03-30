package SetsAndMapsAdvanced;
//On the first line you are given the length of two sets n and m.
//On the next n + m lines there are n numbers that are in the first set and m numbers that are in the second one.
//Find all non-repeating element that appears in both of them, and print them in same order at the console:
//Set with length n = 4: {1, 3, 5, 7}
//Set with length m = 3: {3, 4, 5}
//Set that contains all repeating elements -> {3, 5}

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        LinkedHashSet<Integer> first = new LinkedHashSet();
        LinkedHashSet<Integer> combined = new LinkedHashSet();
        while (n > 0){
            int num = Integer.parseInt(scanner.nextLine());
            first.add(num);
            n--;
        }
        while (m > 0){
            int num = Integer.parseInt(scanner.nextLine());
            if(first.contains(num)) {
                combined.add(num);
            }
            m--;
        }
        System.out.println(combined.toString());
    }
}
