import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/palminad/Documents/SoftUni Java Advanced/Materials/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");

        List<String> list = Files.readAllLines(path);   //четем всеки един ред от файла и го запазваме на нов индекс в листа

        List<Integer> totalSum = new ArrayList<>();

        list.stream().map(String::toCharArray)
                .forEach(charArray ->{
                    int sum = 0;
                    for (char symbol: charArray) {
                        sum +=symbol;
                    }
                    totalSum.add(sum);
                });

        int endSum = 0;
        for (int num:totalSum) {
            endSum += num;
        }
        System.out.println(endSum);
    }
}
