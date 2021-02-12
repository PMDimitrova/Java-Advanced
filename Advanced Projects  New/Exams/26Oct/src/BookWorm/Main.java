package BookWorm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String output = scan.nextLine();
        int size = Integer.parseInt(scan.nextLine());

        String[][] matrix = fillTheMatrix(scan, size);
        String command = scan.nextLine();

        int rowPlayer = findPosition(matrix, "row");
        int colPlayer = findPosition(matrix, "col");

        while (!command.equals("end")) {
            String letter = "";
            String nextLetter = findNextLetter(matrix, rowPlayer, colPlayer, command);

            if (nextLetter.equals("none")) {
                output = output.substring(0, output.length() - 1); //todo check if its correct
            } else {
                if (!nextLetter.equals("-")) {
                    output += nextLetter;
                }
                matrix[rowPlayer][colPlayer] = "-";
                switch (command) {
                    case "up":
                        rowPlayer -=1;
                        break;
                    case "down":
                        rowPlayer+=1;
                        break;
                    case "left":
                        colPlayer-=1;
                        break;
                    case "right":
                        colPlayer+=1;
                        break;
                }
                matrix[rowPlayer][colPlayer] = "P";
            }
            command = scan.nextLine();
        }
        System.out.println(output);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static String findNextLetter(String[][] matrix, int rowP, int colP, String command) {
        String output = "";
        switch (command) {
            case "up":
                if (rowP == 0) {
                    output = "none";
                } else {
                    output = matrix[rowP - 1][colP];
                }
                break;
            case "down":
                if (rowP == matrix.length - 1) {
                    output = "none";
                } else {
                    output = matrix[rowP + 1][colP];
                }
                break;
            case "left":
                if (colP == 0) {
                    output = "none";
                } else {
                    output = matrix[rowP][colP - 1];
                }
                break;
            case "right":
                if (colP == matrix[0].length - 1) {
                    output = "none";
                } else {
                    output = matrix[rowP][colP + 1];
                }
                break;
        }

        return output;
    }

    private static int findPosition(String[][] matrix, String type) {
        int output = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("P")) {
                    if (type.equals("row")) {
                        output = row;
                    } else if (type.equals("col")) {
                        output = col;
                    }
                }
            }
        }
        return output;
    }

    private static String[][] fillTheMatrix(Scanner scan, int size) {
        String[][] output = new String[size][size];
        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            for (int col = 0; col < size; col++) {
                output[row][col] = String.valueOf(line.charAt(col));
            }
        }
        return output;
    }
}
