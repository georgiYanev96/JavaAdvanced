package SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.TreeSet;

//You are given an n number of chemical compounds.
//You need to keep track of all chemical elements used in the compounds and at the end print all unique ones in ascending order:
public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> mySet = new TreeSet<>();
        while (n > 0) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                if (!mySet.contains(input[i])) {
                    mySet.add(input[i]);
            }
            }
            n--;
        }
        System.out.println(mySet.toString());
    }
}
