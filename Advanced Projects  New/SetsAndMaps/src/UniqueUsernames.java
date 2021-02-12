import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n =Integer.parseInt(scan.nextLine());
        Set<String> names = new LinkedHashSet<>();
        String currentName = "";
        while (n-->0){
            currentName = scan.nextLine();
            names.add(currentName);
        }

        names.stream().forEach(name ->{
            System.out.println(name);
        });
    }
}
