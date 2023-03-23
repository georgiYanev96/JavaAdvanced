package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;
//Create a simple program that can convert a decimal number to its binary representation.
//Implement an elegant solution using a Stack.
//Print the binary representation back at the terminal.

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.valueOf(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimal == 0) {
            System.out.println(0);
        }

        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
