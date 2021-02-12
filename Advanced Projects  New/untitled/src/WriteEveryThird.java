import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriteEveryThird {
    public static void main(String[] args) throws IOException {
//        BufferedReader consoleRead = new BufferedReader(
//                new InputStreamReader(System.in));
        //по този начин четем с буферрийд

        // разликата между двете горе и долу е, че при четене от козолата използваме
        //  InputStreamReader, докато при четене от файл използваме FileReader

        BufferedReader reader =
                new BufferedReader(new FileReader("/Users/palminad/Documents/SoftUni Java Advanced" +
                        "/Materials/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt"));
        //инициализираме нов буфериран рийдър като инициализираме нов рийдър и
        //      и подадем path-а на файла, от който ще четем

        Stream<String> lines = reader.lines();
        //прочитам всеки един ред и го запазвам

        List<String> stringLines = lines.collect(Collectors.toList());
        //събирам всички прочетени редове в един лист

        BufferedWriter writer = new BufferedWriter(new FileWriter("out-new.txt"));
        //правим си и writer, защото ще ни трябва надолу в цикъла, за да запазим данните
        // от всеки трети ред; вътре задаваме името на новия файл, който ще се направи сам

        for (int i = 0; i < stringLines.size(); i++) {
            if ((i+1)%3==0){
                writer.write(stringLines.get(i));
                writer.newLine();
            }
        }
        writer.close(); //ЗАДЪЛЖИТЕЛНО затвори накрая

    }
}
