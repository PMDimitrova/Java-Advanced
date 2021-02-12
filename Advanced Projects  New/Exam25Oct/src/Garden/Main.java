package Garden;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputDim = scan.nextLine().split("\\s+");
        int size = Integer.parseInt(inputDim[0]);

        Integer[][] matrix = createMatrix(size);

        String[] coordinates = scan.nextLine().split("\\s+");

        List<List<Integer>> seededFlower = new LinkedList<>();

        while (!coordinates[0].equals("Bloom")) {
            int rowPlant = Integer.parseInt(coordinates[0]);
            int colPlant = Integer.parseInt(coordinates[1]);

            if (rowPlant < 0 || rowPlant >= size || colPlant < 0 || colPlant >= size) {
                System.out.println("Invalid coordinates.");
                coordinates = scan.nextLine().split("\\s+");
                continue;
            } else {          //should we check if there's a flower there already
                matrix[rowPlant][colPlant] = 1;
                List<Integer> flowerPosition = new LinkedList<>();
                flowerPosition.add(rowPlant);
                flowerPosition.add(colPlant);
                seededFlower.add(flowerPosition);
            }
            coordinates = scan.nextLine().split("\\s+");
        }

        for (List<Integer> flower : seededFlower) {
            int row = flower.get(0);
            int col = flower.get(1);
            int initial = matrix[row][col];
            for (int c = 0; c < size; c++) {
                matrix[row][c] = matrix[row][c] + 1;
            }

            for (int r = 0; r < size; r++) {
                matrix[r][col] = matrix[r][col] + 1;
            }
            matrix[row][col] = initial;
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] +" ");
            }
            System.out.println();
        }

    }

    private static Integer[][] createMatrix(int size) {
        Integer[][] output = new Integer[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                output[row][col] = 0;
            }
        }
        return output;
    }
}
