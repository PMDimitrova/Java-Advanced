import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class CountCharacterTypes {

    public static int[] counts = new int[3];
    // 0-vowels, 2 - punctuation, 1 - all others

    public static void main(String[] args) throws IOException {
        String path = "/Users/palminad/Documents/SoftUni Java Advanced/Materials/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        PrintWriter writer = new PrintWriter("outputCountChars.txt");

        Scanner scan = new Scanner(Paths.get(path));

        String vowels = "aeiou";
        String punctuation = "!,.?";

        while (scan.hasNext()) {
            String line = scan.nextLine();
            Arrays.stream(line.split("\\s+"))
                    .forEach(string ->{
                        for (char symbol:string.toCharArray()){
                            String currentString = String.valueOf(symbol);
                            if (vowels.contains(currentString)){
                                counts[0]++;
                            }else if (punctuation.contains(currentString)){
                                counts[2]++;
                            }else{
                                counts[1]++;
                            }
                        }
                    });
        }

        System.out.printf("Vowels: %d%nConsonants: %d%nPunctuation: %d",
                counts[0], counts[1], counts[2]);

    }
}
