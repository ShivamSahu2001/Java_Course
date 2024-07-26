package J14_DP.D3_LongestCommonSubSeq;

public class L6_PrintSCS {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(printShortestSuperSeq(X, Y));
    }
    static String printShortestSuperSeq(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        String str = "";
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                str += (X.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                str += (Y.charAt(j - 1));
                j--;
            }
            else {
                str += (X.charAt(i - 1));
                i--;
            }
        }
        while (i > 0) {
            str += (X.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            str += (Y.charAt(j - 1));
            j--;
        }
        str = reverse(str);
        return str;
    }
    static String reverse(String input) {
        char[] temparray = input.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;
        for (left = 0; left < right; left++, right--) {
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }
        return String.valueOf(temparray);
    }
}
