package StreamsFilesAndDirections.Exercises;
//You are given a file named "input.txt".
//Read and print all of its contents as a sequence of bytes (the binary representation of the ASCII code for each character)
//separated by a single comma.

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "Resources-Files-and-Streams-Lab-Resources/input.txt";
        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
