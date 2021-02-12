import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = fillMatrix (scan, size);

        int sumFirstDiagonal = findFirstSum(matrix, size);
        int sumSecondDiagonal = findSecondSum(matrix,size);

        int result = Math.abs(sumFirstDiagonal - sumSecondDiagonal);
        System.out.println(result);

    }

    private static int findSecondSum(int[][] matrix, int size) {
        int sum = 0;
        for (int col = 0; col < size; col++) {
            for (int row = size - 1; row >=0 ; row--) {
                if ((row + col) == (size -1)){
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int findFirstSum(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row==col){
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int[][] fillMatrix(Scanner scan, int size) {
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
