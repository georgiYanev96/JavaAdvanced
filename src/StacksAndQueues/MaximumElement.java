package StacksAndQueues;
//You have an empty sequence, and you will be given N commands. Each command is one of the following types:
//•	"1 X" - Push the element X into the stack.
//•	"2" - Delete the element present at the top of the stack.
//•	"3" - Print the maximum element in the stack.
//Input
//•	The first line of input contains an integer N, where 1 ≤ N ≤ 105
//•	The next N lines contain commands. All commands will be valid and in the format described
//•	The element X will be in range 1 ≤ X ≤ 109
//•	The type of the command will be in range 1 ≤ Type ≤ 3
//Output

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        int biggest = Integer.MIN_VALUE;
        while (n > 0){
            int[] command = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if(command[0] == 1){
                nums.push(command[1]);
                if(biggest <= command[1]){
                    biggest = command[1];
                }
            }
            if(command[0] == 2){
                if(nums.peek() == biggest){
                    biggest= Integer.MIN_VALUE;
                    nums.pop();
                }

            }
            if(command[0] == 3){
                System.out.println(biggest);
            }
            n--;
        }
    }
}
