package J14_DP.D3_LongestCommonSubSeq;
public class L4_LongestCommonSubString {
    public static void main(String[] args) {
        String x = "abcdxyz";
        String y = "xyzabcd";
        System.out.println(lcsRec(x,y,x.length(),y.length(),0));
        System.out.println(lcsBU(x.toCharArray(), y.toCharArray(),x.length(),y.length()));
        System.out.println(lcsSp(x,y,x.length(),y.length()));
    }
    static int lcsRec(String x, String y, int m, int n, int count) {//T->O(2^max(m,n)),S->O(1)
        if (m == 0 || n == 0) {
            return count;
        }if (x.charAt(m - 1) == y.charAt(n - 1)) {
            count = lcsRec(x,y,m - 1, n - 1, count + 1);
        }
        count = Math.max(count, Math.max(lcsRec(x,y,m, n - 1, 0),
                        lcsRec(x,y,m - 1, n, 0)));
        return count;
    }
    static int lcsBU(char X[], char Y[], int m, int n) {//T-> O(m*n) ,S->O(m*n)
        int dp[][] = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Integer.max(result, dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }
        return result;
    }
    static int lcsSp(String s, String t, int n, int m) {
        int dp[][]=new int[2][m+1];
        int res=0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i%2][j]=dp[(i-1)%2][j-1]+1;
                    if(dp[i%2][j]>res) {
                        res = dp[i % 2][j];
                    }
                }
                else dp[i%2][j]=0;
            }
        }
        return res;
    }
}
