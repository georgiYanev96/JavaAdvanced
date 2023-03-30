package SetsAndMapsAdvanced;

import com.sun.source.tree.Tree;

import java.util.*;

//Write a program that:
//•	Reads from console number of students for a track
//•	Reads on pair of rows:
//o	First line is the name of student
//o	Second line is his score for different number of courses
//•	Print on console “{name} is graduated with {average scores)”
public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> myMap = new TreeMap<>();
        while (n * 2 > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            List<Double> gradesList = new ArrayList<>();
            for (int i = 0; i < grades.length; i++) {
                gradesList.add(grades[i]);
            }
            myMap.put(name, gradesList);

            n--;
        }
        double total = 0;
        int counter = 0;
        double average = 0;

        //Ganio is graduated with 4.09375

        for (Map.Entry<String, List<Double>> student : myMap.entrySet()) {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < student.getValue().size(); i++) {
                total = total + student.getValue().get(i);
                counter++;
            }
            average = total / counter;
            output.append(student.getKey()).append(" is graduated with ").append(average)   ;
            total = 0;
            counter = 0;
            average = 0;
            System.out.println(output);
        }

    }
}
