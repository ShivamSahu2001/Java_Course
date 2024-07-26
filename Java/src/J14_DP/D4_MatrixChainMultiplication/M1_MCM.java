package J14_DP.D4_MatrixChainMultiplication;
import java.util.Arrays;

public class M1_MCM {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 3 };
        System.out.println(McmRec(arr, 1, arr.length-1));
        int[][] dp = new int[100][100];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(McmMemo(dp,arr,1,arr.length-1));
        System.out.println(MatrixChainOrder(arr,arr.length));
    }
    static int McmRec(int p[], int i, int j) {//T->O(2^n),S-O(1)
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = McmRec(p, i, k) + McmRec(p, k + 1, j)
                              + p[i - 1] * p[k] * p[j];

            if (count < min)
                min = count;
        }
        return min;
    }
    static int McmMemo(int[][] dp, int[] arr, int i, int j) {//T-> O(N3 ),C->O(N2)ignoring recursion stack space
        if (i == j) {
            return 0;
        }if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], McmMemo(dp,arr, i, k)
                    + McmMemo(dp,arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j]);
        }
        return dp[i][j];
    }
    static int MatrixChainOrder(int p[], int n) {//T->O(N^3),S->O(N^2)
        int dp[][] = new int[n][n];
        int i, j, k, L, q;
        for (i = 1; i < n; i++)
            dp[i][i] = 0;
        for (L = 2; L < n; L++) {// L is chain length.
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                if (j == n) {
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    q = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < dp[i][j]){
                        dp[i][j] = q;
                    }
                }
            }
        }
        return dp[1][n - 1];
    }
}
