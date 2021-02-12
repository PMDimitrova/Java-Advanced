import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();

        Set<String> nSet = new LinkedHashSet<>();
        Set<String> mSet = new LinkedHashSet<>();

        String number = "";

        for (int i = 0; i < n; i++) {
            number = scan.nextLine();
            nSet.add(number);
        }
        for (int i = 0; i < m; i++) {
           number = scan.nextLine();
           mSet.add(number);
        }

        nSet.retainAll(mSet);
        nSet.stream().forEach(num ->
                System.out.print(num + " "));
    }
}
