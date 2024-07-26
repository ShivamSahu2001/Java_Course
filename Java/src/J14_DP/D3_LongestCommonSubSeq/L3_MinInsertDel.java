package J14_DP.D3_LongestCommonSubSeq;

public class L3_MinInsertDel {
    public static void main(String[] args) {
        String str1 = new String("heap");
        String str2 = new String("pea");
        int m = str1.length();
        int n = str2.length();
        int len = lcs(str1, str2, m, n);
        System.out.println("No of Deletion:"+(m - len));
        System.out.print("No of insertion:"+(n - len));
    }
    static int lcs(String str1, String str2, int m, int n) {
        int L[][] = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (str1.charAt(i - 1)
                        == str2.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;

                else
                    L[i][j] = Math.max(L[i - 1][j],
                            L[i][j - 1]);
            }
        }
        return L[m][n];
    }
}
