//package ReVolt;
//
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class Test {
//
//        Scanner scan = new Scanner(System.in);
//        int size = Integer.parseInt(scan.nextLine());
//        int countCommands = Integer.parseInt(scan.nextLine());
//
//        String[][] matrix = fillTheMatrix(scan, size);
//
//        int playersRow = -1;
//        int playersCol = -1;
//
//        String command = "";
//
//
//        for (int i = 0; i < countCommands; i++) {
//            command = scan.nextLine();
//            playersRow = findPosition(matrix, "row", "f");
//            playersCol = findPosition(matrix, "col", "f");
//
//            makeAMove(matrix, playersRow, playersCol, command);
//
//            System.out.println();
//
//
//
//    }
//
//    private static void makeAMove(String[][] matrix, int playersRow, int playersCol, String command) {
//        boolean outOfField= checkNextPosition(matrix, playersRow, playersCol, command);
//        String nextPosition = findNextPosition(matrix, playersRow, playersCol, command, outOfField);
//        if (!nextPosition.equals("T")) {
//            matrix[playersRow][playersCol] = "-";
//            if (outOfField) {
//                correctPosition(matrix, playersRow, playersCol, command);
//            } else {
//                moveOneStep(matrix, playersRow, playersCol, command);
//            }
//
//            //TODO if its B
//        }else{
//            //clearNextPosition(matrix, playersRow, playersCol, command);
//        }
//
//    }
//
//    private static void moveOneStep(String[][] matrix, int playersRow, int playersCol, String command) {
//        switch (command){
//            case "up":
//                playersRow +=1;
//                break;
//            case "down":
//                playersRow -=1;
//                break;
//            case "left":
//                playersCol -=1;
//                break;
//            case "right":
//                playersCol +=1;
//                break;
//        }
//    }
//
//    private static void correctPosition(String[][] matrix, int playersRow, int playersCol, String command) {
//        switch (command){
//            case "up":
//                playersRow = matrix.length-1;
//                break;
//            case "down":
//                playersRow = 0;
//                break;
//            case "left":
//                playersCol = matrix.length-1;
//                break;
//            case "right":
//                playersCol = 0;
//                break;
//        }
//    }
//
//    private static String findNextPosition(String[][] matrix, int playersRow, int playersCol, String command, boolean outOfField) {
//        String output = "";
//        if (outOfField) {
//            switch (command) {
//                case "up":
//                    output = matrix[matrix.length - 1][playersCol];
//                    break;
//                case "down":
//                    output = matrix[0][playersCol];
//                    break;
//                case "left":
//                    output = matrix[playersRow][matrix.length - 1];
//                    break;
//                case "right":
//                    output = matrix[playersRow][0];
//                    break;
//            }
//        } else {
//            switch (command) {
//                case "up":
//                    output = matrix[playersRow-1][playersCol];
//                    break;
//                case "down":
//                    output = matrix[playersRow+1][playersCol];
//                    break;
//                case "left":
//                    output = matrix[playersRow][playersCol-1];
//                    break;
//                case "right":
//                    output = matrix[playersRow][playersRow+1];
//                    break;
//            }
//        }
//
//        return output;
//    }
//
//    private static boolean checkNextPosition(String[][] matrix, int playersRow, int playersCol, String command) {
//        switch (command) {
//            case "up":
//                if (playersRow == 0) {
//                    return true;
//                }
//                break;
//            case "down":
//                if (playersRow == (matrix.length - 1)) {
//                    return true;
//                }
//                break;
//            case "left":
//                if (playersCol == 0) {
//                    return true;
//                }
//                break;
//            case "right":
//                if (playersCol == (matrix[0].length - 1)) {
//                    return true;
//                }
//                break;
//        }
//        return false;
//    }
//
//    private static int findPosition(String[][] matrix, String direction, String toFind) {
//        int result = -1;
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                if (matrix[row][col].equals(toFind)) {
//                    if (direction.equals("row")) {
//                        result = row;
//                    } else if (direction.equals("col")) {
//                        result = col;
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private static String[][] fillTheMatrix(Scanner scan, int n) {
//        String[][] matrix = new String[n][n];
//        String line;
//        for (int row = 0; row < n; row++) {
//            line = scan.nextLine();
//            for (int col = 0; col < line.length(); col++) {
//                matrix[row][col] = String.valueOf(line.charAt(col));
//            }
//        }
//        return matrix;
//    }
//}
