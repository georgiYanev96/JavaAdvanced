package StacksAndQueues;
//Hot potato is a game in which children form a circle and start passing a hot potato.
//The counting starts with the fist kid.
//Every nth toss the child left with the potato leaves the game.
//When a kid leaves the game, it passes the potato forward.
//This continues repeating until there is only one kid left.
//Create a program that simulates the game of Hot Potato.
//Print every kid that is removed from the circle.
//In the end, print the kid that is left last.

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, input);
        int n = Integer.parseInt(scanner.nextLine());
        while (children.size() > 1) {
            for (int i = 1; i < n; i++) {
                children.offer(children.poll());
                System.out.println("Removed " + children.poll());
            }
        }

        System.out.println("Last is " + children.poll());

    }
}
