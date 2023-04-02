package StreamsFilesAndDirections.Exercises;
//Read the file provided, named "input.txt" and write to another file all lines which number is divisible by 3.
//Line numbers start from one.

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "Resources-Files-and-Streams-Lab-Resources/input.txt";
        String output = "Resources-Files-and-Streams-Lab-Resources/05.WriteEveryThirdLineOutput.txt";


        try (BufferedReader in = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter(new FileWriter(output))) {
            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0)
                    out.println(line);
                counter++;
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
