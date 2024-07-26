package J14_DP.D4_MatrixChainMultiplication;
import java.util.Arrays;

public class M2_PalindromePartitioning {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(minPalinPartRec(str,0,str.length()-1));
        System.out.println(minPalPartion(str));
        System.out.println(minCutBU(str));
    }
    static int minPalinPartRec(String str, int i, int j) {//T->O(2n),C->O(n)
        if (i >= j || isPalindrome(str, i, j))
            return 0;
        int minCuts = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cuts = minPalinPartRec(str, i, k) + minPalinPartRec(str, k + 1, j) + 1;
            minCuts = Math.min(minCuts, cuts);
        }
        return minCuts;
    }
    static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    static int minPalPartion(String str){//T->O(n3),S->O(n2)
        int n = str.length();
        int[][] C = new int[n][n];
        boolean[][] P = new boolean[n][n];
        int i, j, k, L;
        for (i = 0; i < n; i++) {
            P[i][i] = true;
            C[i][i] = 0;
        }
        for (L = 2; L <= n; L++) {
            for (i = 0; i < n - L + 1; i++) {
                j = i + L - 1;
                if (L == 2)
                    P[i][j] = (str.charAt(i) == str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];
                if (P[i][j] == true)
                    C[i][j] = 0;
                else {
                    C[i][j] = Integer.MAX_VALUE;
                    for (k = i; k <= j - 1; k++)
                        C[i][j] = Integer.min(C[i][j],C[i][k] + C[k + 1][j] + 1);
                }
            }
        }
        return C[0][n - 1];
    }
    static int minCutBU(String s) {//T->O(n2),S->O(n2)
        if (s.isEmpty())
            return 0;
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        generatePalindrome(s, pal);
        int[] minCutDp = new int[n];
        Arrays.fill(minCutDp, Integer.MAX_VALUE);
        minCutDp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (pal[0][i]) {
                minCutDp[i] = 0;
            }
            else {
                for (int j = i; j >= 1; j--) {
                    if(pal[j][i]) {
                        if(minCutDp[j - 1] + 1 <minCutDp[i]) {
                            minCutDp[i] = minCutDp[j - 1] + 1;
                        }
                    }
                }
            }
        }
        return minCutDp[n - 1];
    }
    static boolean generatePalindrome(String s, boolean[][] pal) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            pal[i][i] = true;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len == 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                }
            }
        }
        return true;
    }
}
