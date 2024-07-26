package J14_DP.D3_LongestCommonSubSeq;

public class L5_ShortestCommonSuperSeq {//x+y-lcs
    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        System.out.println(superSeqRec(x,y,x.length(),y.length()));
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        System.out.println(superSeqMemo(x, y, x.length(), y.length(), dp) );
        System.out.println(shortestSuperSequence(x,y));
        System.out.println(superSeqBU(x,y,x.length(),y.length()));
    }
    static int superSeqRec(String X, String Y, int m, int n) {//T->O(2min(m, n)),S->O(min(m, n))
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + superSeqRec(X, Y, m - 1, n - 1);

        return 1 + Math.min(superSeqRec(X, Y, m - 1, n),
                superSeqRec(X, Y, m, n - 1));
    }
    static int superSeqMemo(String X, String Y, int n, int m, int[][] dp) {//T-O(n*m),S-O(n*m)
        if (m == 0 || n == 0) {
            dp[n][m] = n + m;
        }

        if (dp[n][m] == 0)
            if (X.charAt(n - 1) == Y.charAt(m - 1)) {
                dp[n][m] = superSeqMemo(X, Y, n - 1, m - 1, dp) + 1;
            }

            else {
                dp[n][m] = Math.min(
                        superSeqMemo(X, Y, n - 1, m, dp) + 1,
                        superSeqMemo(X, Y, n, m - 1, dp) + 1);
            }

        return dp[n][m];
    }
    static int shortestSuperSequence(String x, String y) {//T->O(m*n),S->O(m*n)
        int m = x.length();
        int n = y.length();
        int l = process(x, y, m, n);
        return (m + n - l);
    }
    static int process(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;

                else
                    L[i][j] = Math.max(L[i - 1][j],
                            L[i][j - 1]);
            }
        }
        return L[m][n];
    }
    static int superSeqBU(String X, String Y, int m, int n)
    {
        int[][] dp = new int[m + 1][n + 1];

        // Fill table in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Below steps follow above recurrence
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1
                            + Math.min(dp[i - 1][j],
                            dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }
}
