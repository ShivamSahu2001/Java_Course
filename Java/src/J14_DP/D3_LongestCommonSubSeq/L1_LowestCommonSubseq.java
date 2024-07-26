package J14_DP.D3_LongestCommonSubSeq;
import java.util.Arrays;

public class L1_LowestCommonSubseq {
    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        System.out.println(lcsRec(x,y,x.length(),y.length()));
        System.out.println(lcsMemo(x,y,x.length(),y.length()));
        System.out.println(lcsBU(x,y,x.length(),y.length()));
        System.out.println(lcsSp(x,y));
    }
    static int lcsRec(String x, String y, int m, int n) {//T->O(2^(m*n)),O->O(1)
        if (m == 0 || n == 0) {
                return 0;
        }if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return 1 + lcsRec(x, y, m - 1, n - 1);
        }return Math.max(lcsRec(x, y, m, n - 1), lcsRec(x, y, m - 1, n));
    }
    static int lcsMemo(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        if (m == 0 || n == 0) {
            return 0;
        }if (dp[m][n] != -1) {
            return dp[m][n];
        }if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            dp[m][n] = 1 + lcsMemo(X, Y, m - 1, n - 1);
            return dp[m][n];
        }
        dp[m][n] = Math.max(lcsMemo(X, Y, m, n - 1), lcsMemo(X, Y, m - 1, n));
        return dp[m][n];
    }
    static int lcsBU(String X, String Y, int m, int n) {//t->O(m * n),C->O(m * n)
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
    public static int lcsSp(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int idx1 = 1; idx1 < n + 1; idx1++) {
            for (int idx2 = 1; idx2 < m + 1; idx2++) {
                // If matching
                if (text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1))
                    cur[idx2] = 1 + prev[idx2 - 1];
                else
                    cur[idx2] = Math.max(cur[idx2 - 1], prev[idx2]);
            }
            prev = Arrays.copyOf(cur, m + 1);
        }
        return cur[m];
    }
}
