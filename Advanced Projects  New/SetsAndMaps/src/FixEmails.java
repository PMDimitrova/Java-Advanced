import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> list = new LinkedHashMap<>();

        String name = scan.nextLine();
        String email = "";

        while (!name.equals("stop")){
            email = scan.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
                list.put(name, email);
            }

            name = scan.nextLine();
        }

        list.entrySet().stream()
                .forEach(person ->{
                    System.out.println(person.getKey() + " -> " + person.getValue());
                });
    }
}
