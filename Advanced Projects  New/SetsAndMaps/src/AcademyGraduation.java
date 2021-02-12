import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        String name = "";
        String gradesList = "";

        Map<String, Double> book = new TreeMap<>();

        while(count-->0){
            name = scan.nextLine();
            gradesList = scan.nextLine();
            double[] grades = Arrays.stream(gradesList.split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double avgGrade = getAvarageGrade(grades);
            book.put(name, avgGrade);
        }
        book.entrySet().stream()
                .forEach(student ->{
                    System.out.println(student.getKey() + " is graduated with " + student.getValue());
                });
    }

    private static double getAvarageGrade(double[] grades) {
        double count = 0;
        double sum = 0;

        for (double grade : grades) {
            count++;
            sum += grade;
        }
        return sum/count;
    }
}
