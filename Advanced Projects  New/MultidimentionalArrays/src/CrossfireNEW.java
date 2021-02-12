import java.util.ArrayList;
import java.util.Scanner;

public class CrossfireNEW {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        ArrayList<ArrayList<Integer>> matrix = fillTheMatrix(rows, cols);

        String input = scan.nextLine();

        while (!input.equals("Nuke it from orbit")){
            String[] target = input.split("\\s+");

            int targetRow = Integer.parseInt(target[0]);
            int targetCol = Integer.parseInt(target[1]);
            int radius = Integer.parseInt(target[2]);

            matrix = shootTheTarget(matrix, targetRow, targetCol, radius);

            input = scan.nextLine();
        }

        System.out.println();

    }

    private static ArrayList<ArrayList<Integer>> shootTheTarget(ArrayList<ArrayList<Integer>> matrix,
                                                                int targetRow, int targetCol, int radius) {
        int startPointROW = targetCol -radius;
        int endPointROW = targetCol +radius;
        int startPointCOL = targetRow - radius;
        int endPointCOL = targetRow + radius;

        if (startPointROW<0){
            startPointROW = 0;
        }
        if (startPointCOL<0){
            startPointCOL = 0;
        }



        return matrix;
    }

    private static ArrayList<ArrayList<Integer>> fillTheMatrix(int rows, int cols) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int i = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(i);
                i++;
            }
        }
        return matrix;
    }
}
