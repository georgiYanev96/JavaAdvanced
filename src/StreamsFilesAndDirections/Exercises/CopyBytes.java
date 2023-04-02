package StreamsFilesAndDirections.Exercises;
//Read the file named "input.txt" and write to another file every character's ASCII representation.
//Write every space or new line as it is, e.g. as a space or a new line.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "Resources-Files-and-Streams-Lab-Resources/input.txt";
        String output = "Resources-Files-and-Streams-Lab-Resources/03.CopyBytesOutput.txt";
        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(output);

        int space = ' ';
        int newLine = '\n';

        int oneByte = fis.read();
        while (oneByte != -1) {
            String stringNumber = String.valueOf(oneByte);
            if (oneByte == space || oneByte == newLine) {
                fos.write(oneByte);
            } else {
                for (int i = 0; i < stringNumber.length(); i++) {
                    fos.write(stringNumber.charAt(i));
                }
            }
            oneByte = fis.read();

        }
    }
}
