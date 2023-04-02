package StreamsFilesAndDirections.Exercises;
//Read the file named "input.txt" that is provided for this exercise and write all its content to a file while skipping any punctuation.
//Skip the following symbols: ',', '.', '!', '?'.

import java.io.*;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "Resources-Files-and-Streams-Lab-Resources/input.txt";
        String output = "Resources-Files-and-Streams-Lab-Resources/02.WriteToFileOutput.txt";
        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(output);

        Set<Character> punctuation = Set.of(',','!','?','.');

        int oneByte = fis.read();
        while (oneByte != -1){
            if(!punctuation.contains((char) oneByte)) {
                fos.write(oneByte);
            }
            oneByte = fis.read();
        }

    }
}
