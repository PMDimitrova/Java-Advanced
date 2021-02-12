import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "/Users/palminad/Documents/SoftUni Java Advanced" +
                "/Materials/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
            //String path е целият път до файла заендо с разширението

        FileInputStream inputStream = new FileInputStream(path);
            //пускаме инпут стрийм от файла

        Scanner scan = new Scanner(inputStream);
            //четем от инпут стрийма

        String table = ",.?!";
            //имаме таблица със символи, които да изключим от файла

        FileOutputStream outputStream = new FileOutputStream("output.txt");
            //отваряме оутпутстрийм; ако не зададем друга директория, го прави в текущата, където е main-a

        while(scan.hasNext()){
            //четем от файла, докато има следващ бит, т.е. докато има нещо в текста

            String line = scan.nextLine();
                //хващаме целия следващ ред

            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if ((!table.contains(String.valueOf(symbol)))){
                    outputStream.write(symbol);
                }
                //превъртаме символ по символ дали отговарят на някой от таблицата,
                // ако не отговарят - принтираме/записваме съответния символ във файла,
                // който сме избрали за оутпут
            }
            outputStream.write('\n');
            //това заменя писането на нов ред System.out.println();
            // в write() могат да се слагат само байтове или байт[]
        }
    }
}
