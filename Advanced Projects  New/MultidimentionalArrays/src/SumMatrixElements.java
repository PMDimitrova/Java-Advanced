import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split(",\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int sum = 0;

        for (int row = 0; row < rows; row++) {
            String[] nums = scan.nextLine().split(",\\s+");
            for (int col = 0; col < cols; col++) {
                sum += Integer.parseInt(nums[col]);
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
