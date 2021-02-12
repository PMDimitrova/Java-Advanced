import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rowsOne = scan.nextInt();
        int colsOne = scan.nextInt();
        scan.nextLine();

        int[][] matrixOne = scanMatrix(rowsOne, colsOne, scan);

        int rowsTwo = scan.nextInt();
        int colsTwo = scan.nextInt();
        scan.nextLine();

        int[][] matrixTwo = scanMatrix(rowsTwo, colsTwo, scan);

        boolean areMatricesEqual = findIfMatricesAreEqual (matrixOne,matrixTwo);

        System.out.println(areMatricesEqual ? "equal" : "not equal");
    }

    private static boolean findIfMatricesAreEqual(int[][] matrixOne, int[][] matrixTwo) {
        if (!(matrixOne.length == matrixTwo.length)){
            return false;
        }else if (!(matrixOne[0].length == matrixTwo[0].length))
            return false;
        for (int row = 0; row < matrixOne.length; row++) {
            for (int col = 0; col < matrixOne[0].length; col++) {
                if (!(matrixOne[row][col] == matrixTwo[row][col])){
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] scanMatrix(int rows, int cols, Scanner scan) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int num = scan.nextInt();
                matrix[row][col] = num;
            }
            scan.nextLine();
        }
        return matrix;
    }
}
