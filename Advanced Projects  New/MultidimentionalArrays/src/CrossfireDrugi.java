import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrossfireDrugi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        List<List<Integer>> matrix = new ArrayList<>();
        generateMatrix(matrix, rows, cols);
        String command = scanner.nextLine();

        while (!"Nuke it from orbit".equals(command)) {
            String[] commandTokens = command.split("\\s+");
            int targetRow = Integer.parseInt(commandTokens[0]);
            int targetCol = Integer.parseInt(commandTokens[1]);
            int targetRadius = Integer.parseInt(commandTokens[2]);

            for (int row = targetRow - targetRadius; row <= targetRow + targetRadius; row++) {
                if (isValid(row, targetCol, matrix)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            for (int col = targetCol - targetRadius; col <= targetCol + targetRadius; col++) {
                if (isValid(targetRow, col, matrix)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }
            System.out.println();
            removeZeros(matrix);
            removeEmptyRows(matrix);
            command = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static boolean isValid(int row, int col, List<List<Integer>> matrix) {
        return (row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size());
    }

    private static void removeEmptyRows(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i).isEmpty()) {
                matrix.remove(i);
                i--;
            }
        }
    }

    private static void removeZeros(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).remove(j);
                    j--;
                }
            }
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }

    private static void generateMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> line = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                line.add(number++);
            }
            matrix.add(line);
        }
    }
}