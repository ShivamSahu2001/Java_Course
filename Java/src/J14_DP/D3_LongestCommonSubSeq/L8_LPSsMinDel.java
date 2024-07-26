package J14_DP.D3_LongestCommonSubSeq;

public class L8_LPSsMinDel {//Delete==Insert
    public static void main(String[] args) {
        String str = "abefbac";
        System.out.println(DelRec(str,0,str.length()-1));
        System.out.println(usingLps(str));
        System.out.println(delBU(str));
    }
    public static int DelRec(String str, int i, int j) {//T->O(2^n),S->O(n)
        if (i >= j)
            return 0;
        if (str.charAt(i) == str.charAt(j)) {
            return DelRec(str, i + 1, j - 1);
        }
        return 1 + Math.min(DelRec(str, i + 1, j), DelRec(str, i, j - 1));
    }
    static int usingLps(String str) {//T-> O(n^2),S-> O(n^2)
        int n = str.length();
        int len = lps(str);
        return (n - len);
    }
    static int delBU(String s) {//T-> O(n^2),S-> O(n)
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int prev = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                }
                prev = temp;
            }
        }
        return dp[n - 1];
    }

    static int lps(String str) {
        int n = str.length();
        int L[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            L[i][i] = 1;
        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (str.charAt(i) == str.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Integer.max(L[i][j - 1], L[i + 1][j]);
            }
        }
        return L[0][n - 1];
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
