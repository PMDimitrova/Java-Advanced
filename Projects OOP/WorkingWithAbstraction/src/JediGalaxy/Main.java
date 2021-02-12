package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readPositions(scanner.nextLine());
        Galaxy galaxy = new Galaxy(new Field(dimensions[0], dimensions[1]));


        String positions = scanner.nextLine();
        long starPowerCollected = 0;

        while (!positions.equals("Let the Force be with you")) {
            int[] jedisPos = readPositions(positions);
            int[] sithsPos = readPositions(scanner.nextLine());

            int rowJedi = jedisPos[0];
            int colJedi = jedisPos[1];


            int rowSith = sithsPos[0];
            int colSith = sithsPos[1];

            galaxy.moveSith(rowSith, colSith);

            starPowerCollected += galaxy.moveJedi(rowJedi, colJedi);


            positions = scanner.nextLine();
        }
        System.out.println(starPowerCollected);
    }

    private static boolean isInBounds(int row, int col, int[][] galaxy) {
        return row >= 0 && row < galaxy.length && col >= 0 && col < galaxy[row].length;
    }

    private static int[] readPositions(String positions) {
        return Arrays.stream(positions.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
