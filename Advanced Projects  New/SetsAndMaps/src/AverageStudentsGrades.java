import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, ArrayList<Double>> book = new TreeMap<>();
        int countStudents = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < countStudents; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            Double grade = Double.parseDouble(input[1]);

            book.putIfAbsent(name, new ArrayList<>());

            book.get(name).add(grade);
        }

        book.entrySet().forEach(entry ->{               //entry - student
            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(innerEntry -> System.out.printf("%.2f ", innerEntry));//innerentry - grade
            double avgGrade = getAverage(entry.getValue());
            System.out.printf("(avg: %.2f)%n", avgGrade);
        });

     }

    private static double getAverage(ArrayList<Double> value) {
        double avg = 0.0;
        for (Double grade : value){
            avg += grade;
        }
        return avg/value.size();
    }
}
