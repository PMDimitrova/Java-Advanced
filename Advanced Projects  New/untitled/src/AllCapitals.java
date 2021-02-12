import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/palminad/Documents/SoftUni Java Advanced/Materials/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");

        PrintWriter writer = new PrintWriter("output-AllCapitals.txt");

        Files.readAllLines(path).stream()
                .forEach(line ->{
                    line = line.toUpperCase();
                    writer.append(line);
                    writer.println();
                });
        writer.flush();
        writer.close();
    }
}
