package J14_DP.D3_LongestCommonSubSeq;
public class L2_PrintLCS {
    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        lcs(x,y,x.length(),y.length());
    }
    static void lcs(String x, String y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (x.charAt(i - 1) == y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int index = dp[m][n];
        int temp = index;
        char[] lcs = new char[index + 1];
        //lcs[index] = '\u0000'; // Set the terminating character
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcs[index - 1] = x.charAt(i - 1);
                i--;
                j--;
                index--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }
        for (int k = 0; k < temp; k++)
            System.out.print(lcs[k]);
    }

}
