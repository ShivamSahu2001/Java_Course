package J14_DP.D3_LongestCommonSubSeq;

public class L10_PatternMatching {
    public static void main(String[] args){
        String a = "AXY";
        String b = "ADXCPY";
        if(lcsBU(a,b,a.length(),b.length())==a.length()){
            System.out.println("true");;
        }
        else{
            System.out.println("false");
        }
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
}
