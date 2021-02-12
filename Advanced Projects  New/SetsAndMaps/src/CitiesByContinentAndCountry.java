import java.util.*;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, List<String>>> list = new LinkedHashMap<>();
        // continent, country, city/city/city
        int entries = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < entries; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            list.putIfAbsent(continent, new LinkedHashMap<>());
            list.get(continent).putIfAbsent(country, new LinkedList<>());

            list.get(continent).get(country).add(city);

        }

        list.entrySet().stream()
                .forEach(continent ->{
                    System.out.println(continent.getKey()+":");
                    continent.getValue().entrySet().stream().forEach(innerCountry->{
                        System.out.print("   " + innerCountry.getKey() + " -> ");
                        String listCities = innerCountry.getValue()
                                .stream()
                                .collect(Collectors.joining(", "));
                        System.out.println(listCities);
                    });
                });

        System.out.println();
    }
}
