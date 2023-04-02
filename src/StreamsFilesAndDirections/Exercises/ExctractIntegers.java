package StreamsFilesAndDirections.Exercises;
//Read the file provided, named "input.txt" and extracts all integers that are not a part of a word in a separate file.
//A valid integer is surrounded with white spaces.
//Submit in Judge only the output of the program

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExctractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "Resources-Files-and-Streams-Lab-Resources/input.txt";
        String output = "Resources-Files-and-Streams-Lab-Resources/04.ExtractIntegersOutput.txt";

        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(output);

        Scanner scanner = new Scanner(fis);
        PrintWriter printWriter = new PrintWriter(output);

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                int oneInt = scanner.nextInt();
                printWriter.println(oneInt);
            }else{
                scanner.next();
            }
        }
        printWriter.flush();
        printWriter.close();
        scanner.close();
    }
}
