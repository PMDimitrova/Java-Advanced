import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = scanMatrix (scan, size);

        int row = 0;
        int col = 0;

        for (int i = 0; i < size; i++) {
            System.out.print(matrix[row++][col++] + " ");
        }

        System.out.println();

        row = size - 1;
        col = 0;

        for (int i = 0; i <size; i++) {
            System.out.print(matrix[row--][col++] + " ");
        }

//        for (int row1 = size - 1; row1 >= 0; row1--) {
//            for (int col1 = 0 ; col1 < size ; col1++) {
//                if ((row1 +col1)== (size - 1)){
//                    System.out.print(matrix[row1][col1] + " ");
//                }
//            }
//        }

    }

    private static int[][] scanMatrix(Scanner scan, int size) {
        int[][]matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scan.nextInt();
            }
            scan.nextLine();
        }
        return matrix;
    }
}
