package Bee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mSize = Integer.parseInt(scan.nextLine());

        String[][] matrix = fillTheMatrix(scan, mSize);

        int pollinatedFlowers = 0;

        String direction = scan.nextLine();
        boolean gotLost = false;
        boolean territoryBonus = false;
        int beesRow;
        int beesCol;


        while (!direction.equals("End") && !gotLost) {
            switch (direction) {
                case "up":
                    beesRow = findCurrentRow(matrix);
                    beesCol = findCurrentCol(matrix);
                    if (beesRow == 0) {
                        gotLost = true;
                        System.out.println("The bee got lost!");
                        break;
                    } else {
                        String upperPosition = findUpperPosition(matrix, beesRow, beesCol);
                        if (upperPosition.equals("f")) {
                            pollinateAFlower(matrix, beesRow, beesCol, direction);
                            pollinatedFlowers++;
                        } else if (upperPosition.equals("O")) {
                            matrix[beesRow][beesCol] = ".";
                            if (beesRow < 2) {
                                gotLost = true;
                            }
                            stepOnABonus(matrix, beesRow, beesCol, direction);
                        }
                    }
                    System.out.println("<===UP====>");
                    break;
                case "down":
                    beesRow = findCurrentRow(matrix);
                    beesCol = findCurrentCol(matrix);
                    if (beesRow == mSize - 1) {
                        gotLost = true;
                        System.out.println("The bee got lost!");
                        break;
                    } else {
                        String downPosition = findBelowPosition(matrix, beesRow, beesCol);
                        if (downPosition.equals("f")) {
                            pollinateAFlower(matrix, beesRow, beesCol, direction);
                            pollinatedFlowers++;
                        } else if (downPosition.equals("O")) {
                            matrix[beesRow][beesCol] = ".";
                            if (beesRow >= matrix.length - 2) {
                                gotLost = true;
                            }
                            stepOnABonus(matrix, beesRow, beesCol, direction);
                        }
                    }

                    System.out.println("<===DOWN====>");
                    break;
                case "left":
                    break;
                case "right":
                    break;
            }

            direction = scan.nextLine();
        }

        System.out.println();

    }

    private static String findBelowPosition(String[][] matrix, int row, int col) {
        return matrix[row + 1][col];
    }

    private static void stepOnABonus(String[][] matrix, int row, int col, String direction) {
        switch (direction) {
            case "up":
                if (row > 1) {
                    matrix[row - 1][col] = ".";
                    matrix[row - 2][col] = "B";
                } else if (row == 1) {
                    matrix[row - 1][col] = ".";

                }
                break;
            case "down":
                if (row > matrix.length-2) {
                    matrix[row +1 ][col] = ".";
                    matrix[row + 2][col] = "B";
                } else if (row == matrix.length - 1) {
                    matrix[row + 1][col] = ".";

                }
                break;
            case "right":
                //TODO logic
                break;
            case "left":
                //TODO logic
                break;
        }

    }

    private static void pollinateAFlower(String[][] matrix, int row, int col, String direction) {
        matrix[row][col] = ".";
        switch (direction) {
            case "up":
                matrix[row - 1][col] = "B";
                break;
            case "down":
                matrix[row + 1][col] = "B";
                break;
            case "left":
                matrix[row][col - 1] = "B";
                break;
            case "right":
                matrix[row][col + 1] = "B";
                break;
        }

    }

    private static String findUpperPosition(String[][] matrix, int row, int col) {
        return matrix[row - 1][col];
    }

    private static int findCurrentRow(String[][] matrix) {
        int r = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("B")) {
                    r = row;
                }
            }
        }
        return r;
    }

    private static int findCurrentCol(String[][] matrix) {
        int r = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("B")) {
                    r = col;
                }
            }
        }
        return r;
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
//for (int row = 0; row < matrix.length; row++) {
//        for (int col = 0; col < matrix[0].length; col++) {
//        if (matrix[row][col].equals("B") && row > 0) {
//        if (matrix[row - 1][col].equals("f")) {
//        pollinatedFlowers++;
//        } else if (matrix[row-1][col].equals("O") && row > 1) {
//        territoryBonus = true;
//        }
//        matrix[row][col] = ".";
//        if (territoryBonus && row > 1) {
//        matrix[row - 1][col] = ".";
//        matrix[row - 2][col] = "B";
//        row--;
//        } else if (territoryBonus && row == 1) {
//        matrix[row - 1][col] = ".";
//        System.out.println("The bee got lost!");
//        gotLost = true;
//        break;  // ????????
//        } else {
//        matrix[row - 1][col] = "B";
//        }
//        row--;
//        } else if (matrix[row][col].equals("B") && row == 0) {
//
//        matrix[row][col] = ".";
//        System.out.println("The bee got lost!");
//        gotLost = true;
//        break;
//        }break;
//        }
//        }
