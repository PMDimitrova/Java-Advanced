import java.util.Scanner;

public class MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "aaa";

            }
        }
    }
}
