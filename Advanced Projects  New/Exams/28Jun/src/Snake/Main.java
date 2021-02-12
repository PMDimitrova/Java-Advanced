package Snake;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        String[][] matrix = fillMatrix(scan, size);

        int rowSnake = -1;
        int colSnake = -1;

        int foodQuantity = 0; //need 10 to be fed
        boolean isInTerritory = true;
        //boolean areThereBurrows = findIfThereAreBurrows(matrix);

        while (isInTerritory && foodQuantity < 10) {
            rowSnake = findPosition(matrix, "S", "row");
            colSnake = findPosition(matrix, "S", "col");
            String command = scan.nextLine();
            isInTerritory = findLimits(matrix, rowSnake, colSnake, command);
            if (isInTerritory) {
                colSnake = findPosition(matrix, "S", "col");
                switch (command) {
                    case "up":
                        String upPosition = matrix[rowSnake - 1][colSnake];
                        if (upPosition.equals("*")) {
                            foodQuantity++;
                            moveSnake(matrix, rowSnake, colSnake, command);
                        } else if (upPosition.equals("B")) {
                            int firstBurRow = rowSnake - 1;
                            int firstBurCol = colSnake;
                            int secondBurRow = findSecBurrowPos(matrix, firstBurRow, firstBurCol, "row");
                            int secondBurCol = findSecBurrowPos(matrix, firstBurRow, firstBurCol, "col");
                            moveSnakeTroughBurrow(matrix, rowSnake, colSnake, firstBurRow, firstBurCol, secondBurRow, secondBurCol);
                        } else if (upPosition.equals("-")) {
                            moveSnake(matrix, rowSnake, colSnake, command);
                        }
                        break;

                    case "down":
                        String downPosition = matrix[rowSnake + 1][colSnake];
                        if (downPosition.equals("*")) {
                            foodQuantity++;
                            moveSnake(matrix, rowSnake, colSnake, command);
                        } else if (downPosition.equals("B")) {
                            int firstBurRow = rowSnake + 1;
                            int firstBurCol = colSnake;
                            int secondBurRow = findSecBurrowPos(matrix, firstBurRow, firstBurCol, "row");
                            int secondBurCol = findSecBurrowPos(matrix, firstBurRow, firstBurCol, "col");
                            moveSnakeTroughBurrow(matrix, rowSnake, colSnake, firstBurRow, firstBurCol, secondBurRow, secondBurCol);
                        } else if (downPosition.equals("-")) {
                            moveSnake(matrix, rowSnake, colSnake, command);
                        }
                        break;

                    case "left":
                        String leftPosition = matrix[rowSnake][colSnake - 1];
                        if (leftPosition.equals("*")) {
                            foodQuantity++;
                            moveSnake(matrix, rowSnake, colSnake, command);
                        } else if (leftPosition.equals("B")) {
                            int firstBurRow = rowSnake;
                            int firstBurCol = colSnake - 1;
                            int secondBurRow = findSecBurrowPos(matrix, firstBurRow, firstBurCol, "row");
                            int secondBurCol = findSecBurrowPos(matrix, firstBurRow, firstBurCol, "col");
                            moveSnakeTroughBurrow(matrix, rowSnake, colSnake, firstBurRow, firstBurCol, secondBurRow, secondBurCol);
                        } else if (leftPosition.equals("-")) {
                            moveSnake(matrix, rowSnake, colSnake, command);
                        }
                        break;

                    case "right":
                        String rightPosition = matrix[rowSnake][colSnake + 1];
                        if (rightPosition.equals("*")) {
                            foodQuantity++;
                            moveSnake(matrix, rowSnake, colSnake, command);
                        } else if (rightPosition.equals("B")) {
                            int firstBurRow = rowSnake;
                            int firstBurCol = colSnake + 1;
                            int secondBurRow = findSecBurrowPos(matrix, firstBurRow, firstBurCol, "row");
                            int secondBurCol = findSecBurrowPos(matrix, firstBurRow, firstBurCol, "col");
                            moveSnakeTroughBurrow(matrix, rowSnake, colSnake, firstBurRow, firstBurCol, secondBurRow, secondBurCol);
                        } else if (rightPosition.equals("-")) {
                            moveSnake(matrix, rowSnake, colSnake, command);
                        }
                        break;

                }
            } else {
                rowSnake = findPosition(matrix, "S", "row");
                colSnake = findPosition(matrix, "S", "col");
                matrix[rowSnake][colSnake] = ".";
                break;
            }
        }

        if (!isInTerritory) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodQuantity);
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

    private static void moveSnakeTroughBurrow(String[][] matrix, int rowSnake, int colSnake, int firstBurRow, int firstBurCol, int secondBurRow, int secondBurCol) {
        matrix[rowSnake][colSnake] = ".";
        matrix[firstBurRow][firstBurCol] = ".";
        matrix[secondBurRow][secondBurCol] = "S";
    }

    private static int findSecBurrowPos(String[][] matrix, int firstBurRow, int firstBurCol, String toFind) {
        int output = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if ((!(row == firstBurRow) || !(col == firstBurCol)) && matrix[row][col].equals("B")) {
                    if (toFind.equals("row")) {
                        output = row;
                    } else if (toFind.equals("col")) {
                        output = col;
                    }
                }
            }
        }
        return output;
    }

    private static void moveSnake(String[][] matrix, int rowSnake, int colSnake, String command) {
        matrix[rowSnake][colSnake] = ".";
        switch (command) {
            case "up":
                matrix[rowSnake - 1][colSnake] = "S";
                break;
            case "down":
                matrix[rowSnake + 1][colSnake] = "S";
                break;
            case "left":
                matrix[rowSnake][colSnake - 1] = "S";
                break;
            case "right":
                matrix[rowSnake][colSnake + 1] = "S";
                break;
        }
    }

    private static boolean findLimits(String[][] matrix, int rowSnake, int colSnake, String command) {
        boolean output = true;
        switch (command) {
            case "up":
                if (rowSnake < 1) {
                    output = false;
                }
                break;
            case "down":
                if (rowSnake >= matrix.length - 1) {
                    output = false;
                }
                break;
            case "left":
                if (colSnake < 1) {
                    output = false;
                }
                break;
            case "right":
                if (colSnake >= matrix[0].length - 1) {
                    output = false;
                }
                break;
        }
        return output;
    }

    private static int findPosition(String[][] matrix, String toFind, String rowOrCol) {
        int output = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals(toFind)) {
                    if (rowOrCol.equals("row")) {
                        output = row;
                    } else {
                        output = col;
                    }
                    break;
                }
            }
        }
        return output;
    }

    private static String[][] fillMatrix(Scanner scan, int n) {
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