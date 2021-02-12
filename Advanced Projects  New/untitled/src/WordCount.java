import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String path = "/Users/palminad/Documents/SoftUni Java Advanced/Materials/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        List<String> lines = Files.readAllLines(Path.of(path));

        HashMap<String, Integer> words = new HashMap<>();

        for (String line : lines) {
            String[] wording = line.split("\\s+");
            for (int i = 0; i < wording.length; i++) {
                words.put(wording[i],0);
            }
        }

        String secondFilePath = "/Users/palminad/Documents/SoftUni Java Advanced/Materials/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
        List<String> secondLines = Files.readAllLines(Path.of(secondFilePath));

        for (String line:secondLines) {
            String[] wording = line.split("\\s+");
            for (String word:wording) {
                if (words.containsKey(word)){
                    words.put(word, words.get(word) + 1);
                }
            }
        }
        PrintWriter writer = new PrintWriter("results.txt");
        for (Map.Entry<String, Integer> word: words.entrySet()) {
            writer.println(word.getKey() + " - " + word.getValue());
        }
        writer.close();
    }
}
