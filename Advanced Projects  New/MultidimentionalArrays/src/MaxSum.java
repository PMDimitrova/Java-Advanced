import java.util.Arrays;
import java.util.Scanner;

public class MaxSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = fillMatrix (scan, rows, cols);

        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[3][3];

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int[][] currentMatrix = findCurrentMatrix(matrix, row, col);
                int sumCurrentMatrix = findCurrentSum(currentMatrix);
                if (sumCurrentMatrix>maxSum){
                    maxSum = sumCurrentMatrix;
                    maxMatrix = currentMatrix;

                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMaxMatrix(maxMatrix);
    }

    private static void printMaxMatrix(int[][] matrix) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int findCurrentSum(int[][] matrix) {
        int size = 3;
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static int[][] findCurrentMatrix(int[][] currentMatrix, int row, int col) {
        int[][] matrix = new int[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                matrix[r][c]= currentMatrix[row][col];
                col++;
            }
            col -= 3;
            row++;
        }

        return matrix;
    }

    private static int[][] fillMatrix(Scanner scan, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
