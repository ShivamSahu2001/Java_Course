package J14_DP.D2_UnboundedKnapSack;

import java.util.Arrays;

public class U3_CoinMinWays {//min digit select for sum
    public static void main(String[] args) {
        int coins[] =  {9, 6, 5, 1  };
        System.out.println(minCoinsRec(coins,coins.length,11));
        System.out.println(mincoinsBU(coins,coins.length,11));
    }
    static int minCoinsRec(int coins[], int n, int sum) {//T->O(n^sum),C->O(sum)
        if (sum == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(coins[i] <= sum){
                int sub_res = minCoinsRec(coins, n, sum-coins[i]);
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
                    res = sub_res + 1;
                }
            }
        }
        return res;
    }
    public static int minCoinsMemo(int[] coins, int n, int sum) {//T->O(n*sum),C->O(sum)
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        return process(coins, n, sum, dp);
    }
    public static int process(int[] coins, int n, int sum, int[] dp) {
        if (sum == 0)
            return 0;
        if (dp[sum] != -1)
            return dp[sum];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= sum) {
                int sub_res = process(coins, n, sum - coins[i], dp);
                if (sub_res != Integer.MAX_VALUE
                        && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        dp[sum] = res;
        return res;
    }
    static int mincoinsBU(int coins[], int n, int sum) {//T->O(n*sum),C->O(sum)
        int dp[] = new int[sum + 1];
        dp[0] = 0;
        for (int i = 1; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
        }for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int sub_res = dp[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i]) {
                        dp[i] = sub_res + 1;
                    }
                }
            }
        }
        if(dp[sum]==Integer.MAX_VALUE)
            return -1;

        return dp[sum];
    }
}
