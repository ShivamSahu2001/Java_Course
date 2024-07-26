package J14_DP.D1_Basic;
//https://bit.ly/3q5rlUY
import java.util.*;
public class B4_MaxAdjSum {
    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        int n = arr.length;
        System.out.println(SumRec(n-1,arr));
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(SumMemo(n-1,arr,dp));
        int dp1[] = new int[n];
        Arrays.fill(dp1, -1);
        System.out.println(solveBU(n,arr,dp1));
        System.out.println(solveSp(n,arr));
    }
    static int SumRec(int ind, int[] arr){//T->O(2^N),S->O(N)
        if (ind < 0) return 0;
        if (ind == 0) return arr[ind];
        int pick = arr[ind] + SumRec(ind - 2, arr);
        int nonPick = SumRec(ind - 1, arr);
        return Math.max(pick, nonPick);
    }
    static int SumMemo(int ind, int[] arr, int[] dp) {//T->O(N),S->O(N)
        if (ind < 0) return 0;
        if (ind == 0) return arr[ind];
        if (dp[ind] != -1) return dp[ind];
        int pick = arr[ind] + SumMemo(ind - 2, arr, dp);
        int nonPick = SumMemo(ind - 1, arr, dp);
        return dp[ind] = Math.max(pick, nonPick);
    }
    static int solveBU(int n, int[] arr, int[] dp) {//T->O(N),S->O(N)
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1) {
                pick += dp[i - 2];
            }int nonPick = dp[i - 1];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[n - 1];
    }
    static int solveSp(int n, int[] arr){//T->O(N),S->O(1)
        int prev = arr[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += prev2;
            int nonPick = prev;
            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }
}
