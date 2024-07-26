package J14_DP.D3_LongestCommonSubSeq;
import java.util.Arrays;
public class L9_LongestRepSubSeq {
    public static void main(String[] args) {
        String str = "aabb";
        int m = str.length();
        int[][] dp = new int[1000][1000];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(lrsRec(str.toCharArray(), m, m,dp));
        System.out.println(LRSUsinglcs(str));
        String s1 = "aabb";
        StringBuilder input1 = new StringBuilder();
        input1.append(s1);
        input1.reverse();
        int[][] dp1 = new int[1000][1000];
        for(int[] row : dp1) {
            Arrays.fill(row, -1);
        }
        System.out.println(lrsMemo(input1, 0, 0, dp1));
    }
    static int lrsRec(char X[], int m, int n,int[][] dp) {//T->O(m*n),S->O(m*n)
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (m == 0 || n == 0) {
            return dp[m][n] = 0;
        }
        if (X[m - 1] == X[n - 1] && m != n) {
            return dp[m][n] = lrsRec(X, m - 1, n - 1,dp) + 1;
        }
        return dp[m][n] = Math.max(lrsRec(X, m, n - 1,dp), lrsRec(X, m - 1, n,dp));
    }
    static int lrsMemo(StringBuilder s1, int i, int j, int[][] dp)
    {
        if(i >= s1.length() || j >= s1.length())
        {
            return 0;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        if(dp[i][j] == -1)
        {
            if(s1.charAt(i) == s1.charAt(j) && i != j)
            {
                dp[i][j] = 1 + lrsMemo(s1, i + 1, j + 1, dp);
            }
            else
            {
                dp[i][j] = Math.max(lrsMemo(s1, i, j + 1, dp), lrsMemo(s1, i + 1, j, dp));
            }
        }
        return dp[i][j];

    }
    static int LRSUsinglcs(String str) {//T->O(n^2),S->O(n)
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (str.charAt(i-1) == str.charAt(j-1) && i!=j)
                    dp[i][j] =  1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][n];
    }
}
