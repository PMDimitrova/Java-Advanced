import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = fillMatrix(scan, rows, cols);

        String input = scan.nextLine();

        while (!input.equals("END")){
            String[] command = input.split("\\s+");
            if (command[0].equals("swap") && command.length==5) {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                boolean coordinatesAreValid = checkCoordinates(rows, cols, row1, col1, row2, col2);
                if (coordinatesAreValid) {
                    //[row1][col1] && [row2][col2]
                    String firstSwap = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = firstSwap;

                    printNewMatrix(matrix, rows, cols);
                }
                else{
                    System.out.println("Invalid input!");
                }

            }else{
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }

        System.out.println();
    }

    private static boolean checkCoordinates(int rows, int cols, int row1, int col1, int row2, int col2) {
       if (row2>=rows){
           return false;
       }else if(row1>=rows){
           return false;
       }else if(col1>=cols){
           return false;
       }else if(col2>=cols){
           return false;
       }else
           return true;
    }

    private static void printNewMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] fillMatrix(Scanner scan, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }

        return matrix;
    }
}
