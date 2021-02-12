package PresentDelivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int countOfPresents = Integer.parseInt(bfr.readLine());

        int size = Integer.parseInt(bfr.readLine());

        char[][] matrix = new char[size][size];

        int xPos = -1;
        int yPos = -1;
        int niceKids = 0;
     //fill the matrix
        for (int row = 0; row < matrix.length; row++) {
            String string = bfr.readLine();
            string = string.replaceAll(" ", "");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = string.charAt(col);
                if (string.charAt(col) == 'S') {
                    xPos = row;
                    yPos = col;
                    matrix[row][col] = '-';
                }
                if (string.charAt(col) == 'V') {
                    niceKids++;
                }
            }
        }
        int niceKidsForTest = niceKids;
        int niceKidsWithPresent = 0;
        String command = bfr.readLine();

        while (!"Christmas morning".equals(command) && countOfPresents > 0) {
            switch (command) {
                case "up":
                    xPos--;
                    break;
                case "down":
                    xPos++;
                    break;
                case "left":
                    yPos--;
                    break;
                case "right":
                    yPos++;
                    break;

            }

            if (isSantaOutside(xPos, yPos, size)) {                 //missing this check
                System.out.println("Santa ran out of presents.");
                break;
            }

            if (matrix[xPos][yPos] == 'V') {
                countOfPresents--;
                niceKidsWithPresent++;
                niceKidsForTest--;
                matrix[xPos][yPos] = '-';
            } else if (matrix[xPos][yPos] == 'X') {
                matrix[xPos][yPos] = '-';
            } else if (matrix[xPos][yPos] == 'C') {
                if (matrix[xPos - 1][yPos] != '-') {
                    if (matrix[xPos - 1][yPos] == 'V') {
                        niceKidsWithPresent++;
                        niceKidsForTest--;
                    }
                    matrix[xPos - 1][yPos] = '-';
                    countOfPresents--;
                }
                if (matrix[xPos + 1][yPos] != '-') {
                    if (matrix[xPos + 1][yPos] == 'V') {
                        niceKidsWithPresent++;
                        niceKidsForTest--;
                    }
                    matrix[xPos + 1][yPos] = '-';
                    countOfPresents--;
                }
                if (matrix[xPos][yPos - 1] != '-') {
                    if (matrix[xPos][yPos - 1] == 'V') {
                        niceKidsWithPresent++;
                        niceKidsForTest--;
                    }
                    matrix[xPos][yPos - 1] = '-';
                    countOfPresents--;
                }
                if (matrix[xPos][yPos + 1] != '-') {
                    if (matrix[xPos][yPos + 1] == 'V') {
                        niceKidsWithPresent++;
                        niceKidsForTest--;
                    }
                    matrix[xPos][yPos + 1] = '-';
                    countOfPresents--;
                }
                if (niceKidsForTest <= 0) {
                    break;
                }
                if (countOfPresents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }
            }
            if (countOfPresents == 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }
            if (niceKidsWithPresent == niceKids) {
                break;
            }
            command = bfr.readLine();
        }
        matrix[xPos][yPos] = 'S';
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }

        if (niceKids > niceKidsWithPresent) {
            System.out.printf("No presents for %d nice kid/s.%n", niceKids - niceKidsWithPresent);
        } else {


            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", niceKidsWithPresent);
        }

    }

    public static boolean isSantaOutside(int xPos, int yPos, int size) {
        return xPos < 0 || xPos >= size || yPos < 0 || yPos >= size;
    }
}