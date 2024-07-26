package J14_DP.D3_LongestCommonSubSeq;
import java.util.Arrays;

public class L7_LPSubseq {
    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.println(lpsRec(seq.toCharArray(),0,n-1));
        int dp[][] = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(lpsMemo(seq.toCharArray(), 0, n - 1, dp));
        System.out.println(lpsBU(seq));
        System.out.println(lpsSpace(seq));
    }
    static int lpsRec(char seq[], int i, int j) {//T->O(2^n),S->O(n^2)
        if (i == j) {
            return 1;
        }
        if (seq[i] == seq[j] && i + 1 == j) {
            return 2;
        }
        if (seq[i] == seq[j]) {
            return lpsRec(seq, i + 1, j - 1) + 2;
        }
        return Math.max(lpsRec(seq, i, j - 1), lpsRec(seq, i + 1, j));
    }
    static int lpsMemo(char seq[], int i, int j, int dp[][]) {//T->O(n^2),S->O(n^2)
        if (i == j) {
            return dp[i][j] = 1;
        }
        if (seq[i] == seq[j] && i + 1 == j) {
            return dp[i][j] = 2;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (seq[i] == seq[j]) {
            return dp[i][j] = lpsMemo(seq, i + 1, j - 1, dp) + 2;
        }
        return dp[i][j] = Math.max(lpsMemo(seq, i, j - 1, dp), lpsMemo(seq, i + 1, j, dp));
    }
    public static int lpsBU(String S) {//T->O(n^2),S->O(n^2)
        String R = new StringBuilder(S).reverse().toString();
        int dp[][] = new int[S.length() + 1][R.length() + 1];
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= R.length(); j++) {
                if (S.charAt(i - 1) == R.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[S.length()][R.length()];
    }
    static int lpsSpace(String str){//T-> O(n^2),S-> O(n)
        int n = str.length();
        int[] L = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int back_up = 0;
            for (int j = i; j < n; j++) {
                if (j == i)
                    L[j] = 1;
                else if (str.charAt(i) == str.charAt(j)) {
                    int temp = L[j];
                    L[j] = back_up + 2;
                    back_up = temp;
                } else {
                    back_up = L[j];
                    L[j] = Math.max(L[j], L[j - 1]);
                }
            }
        }
        return L[n - 1];
    }
}
