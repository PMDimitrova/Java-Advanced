import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split("\\s+");

        int[][] matrix = fillMatrix(dimensions,scan);

        String attack = scan.nextLine();

        while (!attack.equals("Nuke it from orbit")){
            String[] tokens = attack.split("\\s+");
            int rowTarget = Integer.parseInt(tokens[0]);
            int colTarget = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            matrix = attackTheTarget (matrix, rowTarget, colTarget, radius);

            attack = scan.nextLine();
        }

        System.out.println();
    }

    private static int[][] attackTheTarget(int[][] matrix, int rowTarget, int colTarget, int radius) {
        int startColToClear = colTarget - radius;    //included
        int endColToClear = colTarget + radius;     //included

        matrix = clearTargetedRow(matrix, rowTarget, startColToClear, endColToClear);

        int startRowToClear = rowTarget -radius;
        int endRowToClear = rowTarget + radius;

        matrix = clearTargetedCol(matrix, colTarget, startRowToClear, endRowToClear);
        
        matrix = clearZeros(matrix);
        System.out.println();

        return matrix;
    }

    private static int[][] clearZeros(int[][] matrix) {
        List<List<Integer>> matrixList = new LinkedList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

            }
        }

        for (int i = 0; i < matrixList.size(); i++) {
            for (int j = 0; j < matrixList.get(i).size(); j++) {
                if (matrixList.get(i).get(j) == 0) {
                    matrixList.get(i).remove(j);
                    j--;
                }
            }
        }
        for (int row = 0; row < matrixList.size(); row++) {
//            for (int col = 0; col < ; i++) {
//  НЕДОВЪРШЕНА ТУК
//            }
        }

        return matrix;
    }

    private static int[][] clearTargetedCol(int[][] matrix, int colTarget, int startRowToClear, int endRowToClear) {
        if (startRowToClear>=0 && endRowToClear<matrix.length){
            for (int row = startRowToClear; row <=endRowToClear ; row++) {
                matrix[row][colTarget] = 0;
            }
        } else if (startRowToClear>=0 && endRowToClear>=matrix.length){
            for (int row = startRowToClear; row < matrix.length; row++) {
                matrix[row][colTarget] = 0;
            }
        }else if (startRowToClear<0 && endRowToClear<matrix.length){
            for (int row = 0; row < endRowToClear; row++) {
                matrix[row][colTarget] = 0;
            }
        }
        return matrix;
    }

    private static int[][] clearTargetedRow(int[][] matrix, int rowTarget, int startColToClear,int endColToClear){
        if (startColToClear>=0 && endColToClear< matrix[0].length){     //if the indexes are valid
            for (int col = startColToClear; col <=endColToClear ; col++) {
                matrix[rowTarget][col] = 0;
            }
        }else if (startColToClear>=0 && endColToClear>=matrix[0].length){    //if the last index is greater than the cols
            for (int col = startColToClear; col <matrix[0].length ; col++) {
                matrix[rowTarget][col] = 0;
            }
        }else if (startColToClear<0 && endColToClear<matrix[0].length){
            for (int col = 0; col <= endColToClear; col++) {
                matrix[rowTarget][col] = 0;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrix(String[] dimensions, Scanner scan) {
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] output = new int[rows][cols];
        int currentNum = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                output[row][col] = currentNum;
                currentNum++;
            }
        }

        return output;
    }
}
