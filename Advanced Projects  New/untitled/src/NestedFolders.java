import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        File file = new File ("/Users/palminad/Documents/SoftUni Java Advanced/Advanced Projects  New/untitled/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams");

        //DFS // BFS  ----> начини за обхождане на дървовидна структура
        //имплементиране на BFS: обикаляне в широчина;        //DFS ще го разглеждаме натгатък, обикаляне в дълбозина

        Deque<File> deque = new ArrayDeque<>();

        deque.add(file);

        int count = 1; //броя на папките, които сме обходили

        while (!deque.isEmpty()){
            File f = deque.poll();
            //вадя първия от опашката
            count++; // увеличавам броя на нещата, които сме обиколили

            System.out.println(f.getName());

            File[] files =  f.listFiles();
            //листвам всичките му деца
            for (File innerFile :files) {
                if(innerFile.isDirectory()){
                    deque.offer(innerFile);
                    //проверяваме дали някой от файловете не е директория и ако е - добавяме го пак в опашката
                }
            }
        }
        System.out.println(count + "folders");


    }
}
