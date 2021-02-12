import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "/Users/palminad/Documents/SoftUni Java Advanced/Materials/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        File folder = new File(path);       //правя си файл на фолдерът, чиито р-р търся

        long sum = 0;

        for (File file:folder.listFiles()){
            sum += file.length();
        }
        System.out.println(sum);
    }
}
