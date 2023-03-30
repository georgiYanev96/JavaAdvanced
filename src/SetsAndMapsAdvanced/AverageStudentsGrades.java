package SetsAndMapsAdvanced;
//Write a program, which reads the name of a student and their grades and adds them to the student record,
//then prints grades along with their average grade – ordered the output by the names of the students.
//Input
//On the first line N – the number of students,
//then on the next N lines student name with grade.

import java.text.DecimalFormat;
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> myMap = new LinkedHashMap<>();
        while (n > 0){
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            if(!myMap.containsKey(name)){
                List<Double> studentGrades = new LinkedList<>();
                studentGrades.add(grade);
                myMap.put(name, studentGrades);
            }else{
                myMap.get(input[0]).add(grade);
            }
            n--;
        }
        //Ivancho -> 5.20 3.20 (avg: 4.20)
        for (Map.Entry<String, List<Double>> entry : myMap.entrySet()) {
            double sum = 0;
            int counter = 0;
            StringBuilder output = new StringBuilder();
            output.append(entry.getKey()).append(" -> ");
            for (double grade: entry.getValue()) {
                sum = (sum + grade);
                counter++;
                output.append(grade).append(" ");
            }
            double average = sum / counter;
            DecimalFormat df = new DecimalFormat(".##");
            output.append("(avg: ").append(df.format(average)).append(")");
            System.out.println(output);
        }

    }
}
