import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> list = new TreeSet<>();

        String guest = scan.nextLine();

        while (!guest.equals("PARTY")){
            list.add(guest);
            guest = scan.nextLine();
        }
        String guestComes = scan.nextLine();

        while (!guestComes.equals("END")){
            list.remove(guestComes);
            guestComes = scan.nextLine();
        }
        System.out.println(list.size());
        for (String g : list) {
            System.out.println(g);
        }
    }
}
