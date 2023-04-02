package StreamsFilesAndDirections.Exercises;
//Read the file provided, named "input.txt" and sort all lines.
//Write text to another text file. Use Path and Files Classes.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {
        Path path = Paths.get("Resources-Files-and-Streams-Lab-Resources/input.txt");
        Path output = Paths.get("Resources-Files-and-Streams-Lab-Resources/06.SortLinesOutput.txt");

        try {
            List<String> lines = Files.readAllLines(path);
            lines = lines.stream().filter(l ->
                    !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(output, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
