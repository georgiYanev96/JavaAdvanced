package StacksAndQueues;
//Somewhere in the future, there is a robotics factory. The current project is assembly line robots.
//Each robot has a processing time, the time it needs to process a product.
//When a robot is free it should take a product for processing and log his name, product and processing start time.
//Each robot processes a product coming from the assembly line.
//A product is coming from the line each second (so the first product should appear at [start time + 1 second]).
//If a product passes the line and there is not a free robot to take it, it should be queued at the end of the line again.
//The robots are standing on the line in the order of their appearance.
//Input
//•	On the first line, you will get the names of the robots and their processing times in
//format "robotName-processTime;robotName-processTime;robotName-processTime"
//•	On the second line, you will get the starting time in format "hh:mm:ss"
//•	Next, until the "End" command, you will get a product on each line.

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scannner = new Scanner(System.in);
        String[] inputRobots = scannner.nextLine().split(";");
        Map<String, Integer> robots = splitRobotsDataIntoLinkMap(inputRobots);

        int[] processTimes = new int[robots.size()];

        String[] time = scannner.nextLine().split(":");

        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        long totalSeconds = hours * 3600L + minutes * 60L + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();
        String line = scannner.nextLine();
        while (!line.equals("End")) {
            products.add(line);
            line = scannner.nextLine();
        }
        while (!products.isEmpty()) {
            totalSeconds++;
            String currentProduct = products.poll();
            decreaseProcessTime(processTimes);
            if(!assignJob(robots, processTimes, currentProduct, totalSeconds)){
                products.offer(currentProduct);
            }

        }
    }

    private static void decreaseProcessTime(int[] processTimes) {
        for (int i = 0; i < processTimes.length; i++) {
            if(processTimes[i] > 0){
                --processTimes[i];
            }
            
        }
    }

    private static boolean assignJob(Map<String, Integer> robots, int[] processTimes, String currentProduct, long totalSeconds) {
        for (int i = 0; i < processTimes.length; i++) {
            if (processTimes[i] == 0) {
                int count = 0;
                for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                    if (count == i) {
                        processTimes[i] = entry.getValue();
                        logJobAssigned(entry.getKey(), currentProduct, totalSeconds);
                        return true;
                    }
                    count++;
                }
            }
        }
        return false;
    }

    private static void logJobAssigned(String name, String currentProduct, long totalSeconds) {
        long hours = (totalSeconds / 3600) % 24;
        long minutes = ((totalSeconds % 3600) / 60) % 60;
        long seconds = totalSeconds % 60;

        System.out.println(String.format("%s - %s [%02d:%02d:%02d]", name, currentProduct, hours, minutes ,seconds));
    }

    private static Map<String, Integer> splitRobotsDataIntoLinkMap(String[] inputRobots) {
        Map<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < inputRobots.length; i++) {
            String line = inputRobots[i];
            int index = line.indexOf("-");
            String name = inputRobots[i].substring(0, index);
            int time = Integer.parseInt(line.substring(index + 1));
            robots.put(name, time);
        }
        return robots;
    }
}

