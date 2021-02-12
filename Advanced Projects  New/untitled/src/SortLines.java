import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/palminad/Documents/SoftUni Java Advanced" +
                "/Materials/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
        //правим си path, който да взима директно файлът, от който ще четем

        List<String> strings = Files.readAllLines(path);
        //с Files.readAllLines(от файла от по-горе) четем всички редове от дадения файл
        //  и ги запазваме в лист от стрингове

        Collections.sort(strings);

        Files.write(Paths.get("outputdemo.txt"), strings);
        //по този начин казваме да запише всичките прочетени стрингове в нов файл,
        //   който инициализираме директно с Paths.get и в скобите задавме името на

    }
}
