import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "/Users/palminad/Documents/SoftUni Java Advanced" +
                "/Materials/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        // може да се сложи файла без целия path до него, ако е локално копиран за проекта

        FileInputStream inputStream = new FileInputStream(path);
        //пускаме инпут стрийм от файла

        Scanner scan = new Scanner(inputStream);
        //четем от инпут стрийма

        FileOutputStream outputStream = new FileOutputStream("output-CopyBytes.txt");
        //отваряме оутпутстрийм; ако не зададем друга директория, го прави в текущата, където е main-a

        int nextByte = inputStream.read();

        while (nextByte != -1) {
            if(nextByte == ' ' || nextByte=='\n'){
                outputStream.write(nextByte);
                //ако байтът е спейс или нов ред - отпечатай го директно
            }else {
                outputStream.write(String.valueOf(nextByte).getBytes());
                //ако текущият байт е различен от нов ред или спейс -
                //  отпечатай цифровата му репрезентация
            }
            nextByte = inputStream.read();
        }
        outputStream.close();
        //затваряме стрийма

        inputStream.close();

    }
}
