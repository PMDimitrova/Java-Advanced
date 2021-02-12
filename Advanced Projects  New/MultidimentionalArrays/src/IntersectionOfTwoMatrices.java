import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        String[][] matrixOne = scanMatrix(rows, cols, scan);
        String[][] matrixTwo = scanMatrix(rows, cols, scan);

        printIntersectionOfMatrices(matrixOne, matrixTwo);
        System.out.println();
    }

    private static void printIntersectionOfMatrices(String[][] matrixOne, String[][] matrixTwo) {
        for (int row = 0; row < matrixOne.length; row++) {
            for (int col = 0; col < matrixOne[0].length; col++) {
                if (matrixOne[row][col].equals(matrixTwo[row][col])){
                    System.out.print(matrixOne[row][col] + " ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private static String[][] scanMatrix(int rows, int cols, Scanner scan) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scan.nextLine().split("\\s+");
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = currentRow[col];
            }
        }
        return matrix;
    }
}
