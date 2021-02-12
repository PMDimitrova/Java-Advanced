import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> list = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            String vowel = String.valueOf(input.charAt(i));
            list.putIfAbsent(vowel, 0);
            list.put(vowel, list.get(vowel) + 1);
        }
       list.entrySet().stream()
               .forEach(element ->{
                   System.out.printf("%s: %d time/s%n", element.getKey(), element.getValue());
               });
    }
}
