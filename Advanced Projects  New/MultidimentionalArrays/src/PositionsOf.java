import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scan.nextInt();
            }
            scan.nextLine();
        }
        int numToFind = scan.nextInt();

        findNumberInMatrix(matrix, numToFind);

        System.out.println();
    }

    private static void findNumberInMatrix(int[][] matrix, int numToFind) {
        boolean numNotFound = true;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == numToFind){
                    System.out.println(row + " " + col);
                    numNotFound = false;
                }
            }
        }

        if (numNotFound){
            System.out.println("not found");
        }
    }
}
