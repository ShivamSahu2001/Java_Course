package J7_Searching;
import java.util.Arrays;
public class S15_BSMatrix_2D {
    public static void main(String[] args) {
        int[][] arr = {
//                {10, 20, 30, 40},
//                {15, 25, 35, 45},
//                {28, 29, 37, 49},
//                {33, 34, 38, 50}
                {10, 20, 30},
                {15, 25, 35},
                {28, 29, 37},
                {33, 34, 38}
        };
        System.out.println(Arrays.toString(searchRowCol(arr, 37)));
    }

    static int[] searchRowCol(int[][] matrix, int target) {
        int r = 0;
//        int c = matrix[0].length - 1; //also valid for m*n matrix
        int c = 2;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r, c};
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1, -1};
    }
}