
import java.io.*;
import java.util.Scanner;

public class ExtractIntegerNEW {
    public static void main(String[] args) throws IOException {
        String path = "/Users/palminad/Documents/SoftUni Java Advanced" +
                "/Materials/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

        Scanner scanner = new Scanner(new FileInputStream(path));   //пускаме скенер по инпутстрийм от файла, зададен с path

        PrintWriter writer = new PrintWriter("integers-out-new.txt");       //правим си нов "печатач" и го караме да изпечата във файл в текущата директория

        while (scanner.hasNext()){       // пускаме цикъл, докато стриймът от скенера има число
            if (scanner.hasNextInt()) {     // проверяваме дали следващото е int и, ако е, принтираме надолу
                int number = scanner.nextInt();
               // writer.println(number);
                System.out.println(number);
            }
            scanner.next();     //сканираме следващия байт

            writer.flush();     //извеждаме всичко от буфера в програмата, иначе ще си зависне в буфера

            writer.close();     //затваряме целия поток, понеже няма да ползваме повече writer-a
        }

    }
}
