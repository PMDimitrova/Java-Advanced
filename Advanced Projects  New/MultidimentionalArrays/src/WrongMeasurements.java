import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }


    }
}
