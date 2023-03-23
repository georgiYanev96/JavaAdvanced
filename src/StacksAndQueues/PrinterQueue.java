package StacksAndQueues;
//The printer queue is a simple way to control the order of files sent to a printer device.
//We know that a single printer can be shared between multiple devices.
//So to preserve the order of the files sent, we can use queue.
//Write down a program which takes filenames until "print" command is received.
//Then as output print the filenames in the order of printing.
//Some of the tasks may be canceled if you receive "cancel" you have to remove the first file to be printed.
//If there is no current file to be printed print "Printer is on standby".

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("print")) {
                break;
            }
            if (input.equals("cancel") && queue.isEmpty()) {
                System.out.println("Printer is on standby");
            } else if (input.equals("cancel") && !queue.isEmpty()) {
                System.out.printf("Canceled %s%n", queue.remove());
            } else {
                queue.add(input);
            }
        }
        for (int i = 0; i <= queue.size(); i++) {
            System.out.println(queue.remove());
        }
    }
}

