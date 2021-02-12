import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "/Users/palminad/Documents/SoftUni Java Advanced/Advanced Projects  New/untitled/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        File file = new File((path));

        FileInputStream fileInputStream = new FileInputStream(file);

        try(fileInputStream){
            int oneByte = fileInputStream.read();
            while (oneByte>-1){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileInputStream.read();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        fileInputStream.close();
    }
}
