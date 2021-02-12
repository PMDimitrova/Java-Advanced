import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class LineNumbers {

    public static int count = 1;
    public static void main(String[] args) throws IOException {
        String path = "/Users/palminad/Documents/SoftUni Java Advanced/Materials/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("outputLineNumbers.txt");

        int counter = 1;

        for (String currentLine:lines) {
            writer.append(counter + ". " + currentLine + System.lineSeparator());
            counter++;
        }

//        while (scanner.hasNext()){
//            String line = scanner.nextLine();
//            line = String.valueOf(count) + ". " + line + System.lineSeparator();
//            writer.append(line);
//
//        }
        writer.flush();
        writer.close();

    }
}
