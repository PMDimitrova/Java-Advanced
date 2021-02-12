package PresentDelivery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countPresents = Integer.parseInt(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());

        String[][] matrix = fillTheMatrix(scan, size);

        // S for Santa
        // X for a naughty kid -> cell sets to -
        // V for a nice kid  -> receives a present -> cell sets to -
        // C for cookies  -> up,down, left, right receive a present -> cell sets to -
        // - all other
        String command = "";
        int rowSanta = -1;
        int colSanta = -1;
        int kidsWithPresents = 0;

        while (countPresents > 0 && !command.equals("Christmas morning")) {

            rowSanta = findSantasPosition(matrix, "row");
            colSanta = findSantasPosition(matrix, "col");

            String nextHouse = "";
            command = scan.nextLine();
            switch (command) {
                case "up":
                    nextHouse = matrix[rowSanta - 1][colSanta]; //what child do we have in the next house
                    matrix[rowSanta][colSanta] = "-";  //make current house "-"
                    matrix[rowSanta - 1][colSanta] = "S"; //make next house "S"
                    rowSanta -= 1; // update Santa's position
                    break;
                case "down":
                    nextHouse = matrix[rowSanta + 1][colSanta];
                    matrix[rowSanta][colSanta] = "-";
                    matrix[rowSanta + 1][colSanta] = "S";
                    rowSanta += 1;
                    break;
                case "left":
                    nextHouse = matrix[rowSanta][colSanta - 1];
                    matrix[rowSanta][colSanta] = "-";
                    matrix[rowSanta][colSanta - 1] = "S";
                    colSanta -= 1;
                    break;
                case "right":
                    nextHouse = matrix[rowSanta][colSanta + 1];
                    matrix[rowSanta][colSanta] = "-";
                    matrix[rowSanta][colSanta + 1] = "S";
                    colSanta += 1;
                    break;
            }
            if (isSantaOutside(rowSanta, colSanta, size)) {                 //missing this check
                System.out.println("Santa ran out of presents.");
                break;
            }
            switch (nextHouse) {
                case "V":
                    countPresents--;
                    kidsWithPresents++;
                    break;
                case "C":       //TODO does a naughty kid receive a present here, now it doesnt? or the kid in the C-house gets the present..?? // doesnt matter
                    countPresents--;
                    //kidsWithPresents++; //TODO is the kid with C-house a nice (should we count it or not?) // doesnt matter
                    if (rowSanta > 0) { //up
                        if (matrix[rowSanta - 1][colSanta].equals("V") || matrix[rowSanta - 1][colSanta].equals("X")) {
                            kidsWithPresents++;
                            countPresents--;
                        }
                        matrix[rowSanta - 1][colSanta] = "-";
                    }
                    if (rowSanta < matrix.length - 1) { //down
                        if (matrix[rowSanta + 1][colSanta].equals("V") || matrix[rowSanta - 1][colSanta].equals("X")) {
                            kidsWithPresents++;
                            countPresents--;
                        }
                        matrix[rowSanta + 1][colSanta] = "-";
                    }
                    if (colSanta > 0) { //left
                        if (matrix[rowSanta][colSanta - 1].equals("V") || matrix[rowSanta - 1][colSanta].equals("X")) {
                            kidsWithPresents++;
                            countPresents--;
                        }
                        matrix[rowSanta][colSanta - 1] = "-";
                    }
                    if (colSanta < matrix[0].length - 1) { //right
                        if (matrix[rowSanta][colSanta + 1].equals("V") || matrix[rowSanta - 1][colSanta].equals("X")) {
                            kidsWithPresents++;
                            countPresents--;
                        }
                        matrix[rowSanta][colSanta + 1] = "-";
                    }
                    break;
            }

        }

        int numOfNiceKidsWithoutPresent = checkMatrixForNiceKids(matrix);

        if (countPresents<=0){ //TODO check if it also needs the command to be diff than Christmas morning // doesnt matter

            System.out.println("Santa ran out of presents!");
        }
        printNeighbourhood(matrix);

        if (numOfNiceKidsWithoutPresent==0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.", kidsWithPresents);
        }else{
            System.out.printf("No presents for %d nice kid/s.", numOfNiceKidsWithoutPresent);
        }

    }

    private static boolean isSantaOutside(int rowSanta, int colSanta, int size) {
        return rowSanta < 0 || rowSanta >= size || colSanta < 0 || colSanta >= size;
    }

    private static void printNeighbourhood(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int checkMatrixForNiceKids(String[][] matrix) {
        int output = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("V")) {
                    output++;
                }
            }
        }
        return output;
    }

    private static int findSantasPosition(String[][] matrix, String direction) {
        int output = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("S")) {
                    if (direction.equals("row")) {
                        output = row;
                    } else if (direction.equals("col")) {
                        output = col;
                    }
                }
            }
        }
        return output;
    }

    private static String[][] fillTheMatrix(Scanner scan, int n) {
        String[][] matrix = new String[n][n];
        String[] line;
        for (int row = 0; row < n; row++) {
            line = scan.nextLine().split("\\s+");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = String.valueOf(line[col]);
            }
        }
        return matrix;
    }
}