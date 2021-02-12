import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path firstPath = Path.of("/Users/palminad/Documents/SoftUni Java Advanced/Materials/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        Path secondPath = Path.of("/Users/palminad/Documents/SoftUni Java Advanced/Materials/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");

        List<String> firstLines = Files.readAllLines(firstPath);
        List<String> secondLines = Files.readAllLines(secondPath);

        PrintWriter writer = new PrintWriter("thirdFile.txt");

        firstLines.forEach(line -> writer.println(line));
        secondLines.forEach(writer::println);

        writer.close();
    }
}
