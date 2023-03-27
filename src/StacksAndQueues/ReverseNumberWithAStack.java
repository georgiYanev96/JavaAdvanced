package StacksAndQueues;
//Write a program that reads N integers from the console and reverses them using a stack.
//Use the ArrayDeque<Integer> class. Just put the input numbers in the stack and pop them.

import java.lang.reflect.Array;
import java.util.*;

public class ReverseNumberWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            nums.push(input[i]);
        }
        for (int i = nums.size(); i > 0; i--) {
            System.out.print(nums.pop() + " ");
        }
    }
}
