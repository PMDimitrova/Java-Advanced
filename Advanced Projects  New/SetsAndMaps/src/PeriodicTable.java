import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Set<String> list = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] compound = scan.nextLine().split("\\s+");
            Arrays.stream(compound).forEach(element ->
                    list.add(element));
        }
        list.stream().forEach(e ->
                System.out.print(e + " "));
    }
}
