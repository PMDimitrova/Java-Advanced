package Exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<String, Function<List<Integer>, List<Integer>>> functions = new HashMap<>();

        functions.put("add", e -> e.stream()
                .map(val -> val + 1)
                .collect(Collectors.toList()));

        functions.put("multiply", e -> e.stream()
                .map(val -> val * 2)
                .collect(Collectors.toList()));

        functions.put("subtract", e -> e.stream()
                .map(val -> val - 2)
                .collect(Collectors.toList()));

        String command = scan.nextLine();

        while (!command.equals("end")) {
            if (command.equals("print")) {
                numbers
                        .forEach(e -> System.out.print(e + " "));
            } else {
                numbers = functions.get(command).apply(numbers);
            }
            command = scan.nextLine();
        }

    }
}