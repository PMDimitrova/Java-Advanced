package ReVolt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int countCommands = Integer.parseInt(scan.nextLine());

        String[][] matrix = fillTheMatrix(scan, size);

        int playersRow = -1;
        int playersCol = -1;
        int nextRow = -1;
        int nextCol = -1;

        String command = "";
        boolean isWon = false;

        label:
        for (int i = 0; i < countCommands; i++) {
            command = scan.nextLine();
            playersRow = findPosition(matrix, "row", "f");
            playersCol = findPosition(matrix, "col", "f");
            nextRow = findNextPos(matrix, playersRow, "row", command);
            nextCol = findNextPos(matrix, playersCol, "col", command);

            switch (matrix[nextRow][nextCol]) {
                case "F":
                    isWon = true;
                    movePlayerOnce(matrix, playersRow, playersCol, nextRow, nextCol);
                    break label;
                case "B":
                    movePlayerOnce(matrix, playersRow, playersCol, nextRow, nextCol);
                    playersRow = nextRow;
                    playersCol = nextCol;
                    nextRow = findNextPos(matrix, playersRow, "row", command);
                    nextCol = findNextPos(matrix, playersCol, "col", command);
                    movePlayerOnce(matrix, playersRow, playersCol, nextRow, nextCol);
                    matrix[playersRow][playersCol] = "B";                           //edge case when we have to go back
                    break;
                case "-":  //done
                    movePlayerOnce(matrix, playersRow, playersCol, nextRow, nextCol);
                    break;
            }
        }
        if (isWon){
            System.out.println("Player won!");
        }else{
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void movePlayerOnce(String[][] matrix, int playersRow, int playersCol, int nextRow, int nextCol) {
        matrix[playersRow][playersCol] = "-";
        matrix[nextRow][nextCol] = "f";
    }

    private static void correctNextPosition(String[][] matrix, int nextRow) {
    }

    private static int findNextPos(String[][] matrix, int num, String direction, String command) {
        int output = num;
        if (direction.equals("row")) {
            if (command.equals("up")){
                if (num == 0) {
                    output = matrix.length - 1;
                } else {
                    output = num - 1;
                }
            }else if (command.equals("down")){
                if (num == matrix.length - 1) {
                    output = 0;
                } else {
                    output = num + 1;
                }
            }
        }else if (direction.equals("col")){
            if (command.equals("left")){
                if (num == 0){
                    output = matrix.length-1;
                }else {
                    output = num - 1;
                }
            }else if (command.equals("right")){
                if (num == matrix.length - 1) {
                    output = 0;
                } else {
                    output = num + 1;
                }
            }
        }
        return output;
    }

    private static int findPosition(String[][] matrix, String direction, String toFind) {
        int result = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals(toFind)) {
                    if (direction.equals("row")) {
                        result = row;
                    } else if (direction.equals("col")) {
                        result = col;
                    }
                }
            }
        }
        return result;
    }

    private static String[][] fillTheMatrix(Scanner scan, int n) {
        String[][] matrix = new String[n][n];
        String line;
        for (int row = 0; row < n; row++) {
            line = scan.nextLine();
            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = String.valueOf(line.charAt(col));
            }
        }
        return matrix;
    }
}
