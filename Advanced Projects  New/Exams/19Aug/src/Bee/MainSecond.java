package Bee;

import java.util.Scanner;

public class MainSecond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = fillTheMatrix(scan, size);

        int rowBee = findBeesPosition(matrix, "row");
        int colBee = findBeesPosition(matrix, "col");

        String command = scan.nextLine();
        int pollinatedFlowers = 0;
        boolean outOfTerritory = false;

        while (!command.equals("End")) {
            String nextPosition = findNextPosition(matrix, rowBee, colBee, command);
            if (nextPosition.equals("none")) { //bee got out of territory
                outOfTerritory = true;

            } else {
                if (nextPosition.equals("f")) {
                    pollinatedFlowers++;
                } else if (nextPosition.equals("O")) {//bee gets bonus move in same direction
                    matrix[rowBee][colBee] = "."; //sets current pos to "."
                    switch (command) {       //move the bee onto the O-position
                        case "up":
                            rowBee -= 1;
                            break;
                        case "down":
                            rowBee += 1;
                            break;
                        case "left":
                            colBee -= 1;
                            break;
                        case "right":
                            colBee += 1;
                            break;
                    }
                    nextPosition = findNextPosition(matrix, rowBee, colBee, command); //finds the position after the O-pos
                    if (nextPosition.equals("none")) {
                        outOfTerritory = true;
                    } else {
                        if (nextPosition.equals("f")) {
                            pollinatedFlowers++;
                        }

                        matrix[rowBee][colBee] = "B"; //O-pos is set to B
                    }
                }
            }
            matrix[rowBee][colBee] = ".";   //sets current pos to "."
            if (!outOfTerritory) {
                switch (command) {       //move the bee to the next position
                    case "up":
                        rowBee -= 1;
                        break;
                    case "down":
                        rowBee += 1;
                        break;
                    case "left":
                        colBee -= 1;
                        break;
                    case "right":
                        colBee += 1;
                        break;
                }
                matrix[rowBee][colBee] = "B";
            }
            if (outOfTerritory){
                System.out.println("The bee got lost!");
                break;
            }
            command = scan.nextLine();
        }

        if (pollinatedFlowers>=5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5-pollinatedFlowers));
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static String findNextPosition(String[][] matrix, int rowBee, int colBee, String command) {
        String output = "none";
        switch (command) {
            case "up":
                if (rowBee != 0) {
                    output = matrix[rowBee - 1][colBee];
                }
                break;
            case "down":
                if (rowBee != (matrix.length - 1)) {
                    output = matrix[rowBee + 1][colBee];
                }
                break;
            case "left":
                if (colBee != 0) {
                    output = matrix[rowBee][colBee - 1];
                }
                break;
            case "right":
                if (colBee != (matrix.length - 1)) {
                    output = matrix[rowBee][colBee + 1];
                }
                break;
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

    private static int findBeesPosition(String[][] matrix, String type) {
        int output = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("B")) {
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
}