import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> collectables = new LinkedHashMap<>();

        String resource = scan.nextLine();
        int quantity = 0;

        while (!resource.equals("stop")){
            quantity = Integer.parseInt(scan.nextLine());

            collectables.putIfAbsent(resource, 0);
            collectables.put(resource, collectables.get(resource) + quantity);

            resource = scan.nextLine();
        }
        collectables.entrySet().stream()
                .forEach(res ->{
                    System.out.println(res.getKey() + " -> " + res.getValue());
                });
    }
}
