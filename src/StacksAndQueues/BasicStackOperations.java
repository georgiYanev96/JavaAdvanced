package StacksAndQueues;
//You will be given an integer N representing the number of elements to push onto the stack,
//an integer S representing the number of elements to pop from the stack and finally an integer X,
//an element that you should check whether is present in the stack. If it is, print true on the console.
// If it’s not, print the smallest element currently present in the stack.
//Input
//•	On the first line, you will be given N, S and X separated by a single space.
//•	On the next line, you will be given a line of numbers separated by one or more white spaces.
//Output
//•	On a single line print either true if X is present in the stack otherwise print the smallest element in the stack.
//•	If the stack is empty print 0.

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]);
        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < data.length; i++) {
            nums.push(data[i]);
        }
        for (int i = S; i > 0; i--) {
           nums.pop();
        }
        if(nums.contains(X)){
            System.out.println("true");
        }else{
            int smallest = nums.pop();
            for (int i = nums.size()-1 ; i > 0; i--) {
                if(nums.peek() <= smallest){
                    smallest = nums.pop();
                }else{
                    nums.pop();
                }
            }
            System.out.println(smallest);
        }

    }
}
