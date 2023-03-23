package StacksAndQueues;

import java.util.*;

//Create a simple calculator that can evaluate simple expressions that will not hold any operator different
//from addition and subtraction. There will not be parentheses or operator precedence.
//Solve the problem using a Stack.
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);
        while (stack.size() > 1) {
            int first = Integer.valueOf(stack.pop());
            String op = stack.pop();
            int second = Integer.valueOf(stack.pop());

            switch (op) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
        }

        System.out.println(stack.pop());

    }
}
