import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String direction = scan.nextLine();
        int endIndexOfSubstration = direction.length() - 1;
        direction = direction.substring(7, endIndexOfSubstration);
        int degrees = Integer.parseInt(direction);
        ArrayList<String> input = new ArrayList<>();

        String wordsInput = scan.nextLine();

        while (!wordsInput.equals("END")) {
            input.add(wordsInput);
            wordsInput = scan.nextLine();
        }

        String[][] text = fillMatrix(input);
        //finding end position regardless of the full cycles:
        int simplifiedRotation = degrees / 90;
        simplifiedRotation = simplifiedRotation%4;

        switch (simplifiedRotation){
            case 0:
                //text stays the same, so just print it
                for (int row = 0; row < text.length; row++) {
                    for (int col = 0; col < text[0].length; col++) {
                        System.out.print(text[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 1:
                rotateTextTwoTimes (text);
                break;
            case 2:
                rotateTextTreeTimes(text);
                break;
//            case 3:
//                rotateTextFourTimes(text);
//                break;
        }

        //System.out.println(simplifiedRotation);
    }

    private static void rotateTextTreeTimes(String[][] text) {

//        int inputRows = 0;
//        int inputCols = text[0].length-1;
//
//        for (int row = 0; row < text.length; row++) {
//            for (int col = 0; col < text[0].length; col++) {
//                System.out.print(text[inputRows][inputCols]);
//                inputCols++;
//            }
//            inputCols = 0;
//            System.out.println();
//            inputRows++;
//        }
    }

    private static void rotateTextTwoTimes(String[][] text) {
        int rowsRotated = text[0].length;
        int colsRotated = text.length;

        int rowInput = text.length-1;
        int colInput = 0;

        for (int row = 0; row < rowsRotated; row++) {
            for (int col = 0; col < colsRotated; col++) {
                System.out.print(text[rowInput][colInput]);
                rowInput --;
                // TODO: да се дооправи последователността, защото печата по диагонал
            }
            rowInput = text.length-1;
            System.out.println();
            colInput++;
        }
    }

    private static String[][] fillMatrix(ArrayList<String> input) {
        int rows = input.size();
        int cols = 0;

        for (String word : input) {
            if (word.length() > cols) {
                cols = word.length();
            }
        }

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col > (input.get(row).length() - 1)) {
                    matrix[row][col] = " ";
                }else {
                    char vowel = input.get(row).charAt(col);
                    String charToAdd = String.valueOf(vowel);
                    matrix[row][col] = charToAdd;
                }
            }
        }

        return matrix;
    }
}
