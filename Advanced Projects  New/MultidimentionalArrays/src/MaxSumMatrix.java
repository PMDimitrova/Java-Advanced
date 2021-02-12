import java.util.Scanner;

public class MaxSumMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split(",\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = scanMatrix(scan, rows, cols);

        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols-1; col++) {
                int currentSum = 0;
                int one = matrix[row][col];
                int two = matrix[row + 1][col];
                int tree = matrix[row][col + 1];
                int four = matrix[row + 1][col + 1];
                currentSum = one + two + tree + four;
                if (currentSum>maxSum){
                    maxSum = currentSum;
                    maxMatrix[0][0] = one;
                    maxMatrix[0][1] = tree;
                    maxMatrix[1][0] = two;
                    maxMatrix[1][1] = four;
                }
            }
        }
        printMaxSubmatrix(maxMatrix);
        System.out.println(maxSum);
    }

    private static void printMaxSubmatrix(int[][] maxMatrix) {
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(maxMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] scanMatrix(Scanner scan, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] nums = scan.nextLine().split(",\\s+");
            for (int col = 0; col < cols; col++) {
               matrix[row][col] = Integer.parseInt(nums[col]);
            }
        }
        return matrix;
    }
}
