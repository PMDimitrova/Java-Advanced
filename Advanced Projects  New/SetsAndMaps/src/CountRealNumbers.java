import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Double, Integer> listNums = new LinkedHashMap<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(n -> {
                    listNums.putIfAbsent(n, 0);
                    listNums.put(n, listNums.get(n) + 1);
                });

        String output = listNums.entrySet().stream()
                .map(entry -> String.format("%.1f -> %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(output);
    }
}

