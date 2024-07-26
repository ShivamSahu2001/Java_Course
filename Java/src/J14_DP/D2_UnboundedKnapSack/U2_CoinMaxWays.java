package J14_DP.D2_UnboundedKnapSack;
import java.util.Arrays;
import java.util.List;
public class U2_CoinMaxWays {
    public static void main(String[] args) {
        int coins[] = { 1, 2, 3 };
        List<Integer> coin = Arrays.asList(1, 2, 3);
        int n = coins.length;
        int sum =5;
        System.out.println(countMaxRec(coins,coins.length,5));
        System.out.println(countMaxMemo(coins,5,coins.length));
        System.out.println(countMaxBU(coin,n,sum));
        System.out.println(countMaxSp(coins,n,sum));
    }
    static int countMaxRec(int coins[], int n, int sum){//T->O(2sum),S->O(sum)
        if (sum == 0) {
            return 1;
        }if (sum < 0 && n <= 0) {
            return 0;
        }return countMaxRec(coins, n - 1, sum) + countMaxRec(coins, n, sum - coins[n - 1]);
    }
    static int countMaxMemo(int[] coins, int sum, int n) {//T->O(N*sum),S->O(N*sum)
        int[][] dp = new int[n + 1][sum + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        if (sum == 0)
            return dp[n][sum] = 1;
        if (n == 0 || sum<0)
            return 0;
        if (dp[n][sum] != -1)
            return dp[n][sum];
        return dp[n][sum] = countMaxMemo(coins, sum - coins[n - 1], n)
                + countMaxMemo(coins, sum, n - 1);
    }
    static int countMaxBU(List<Integer> coins, int n, int sum) {//T->O(N*sum),S->O(N*sum)
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] += dp[i - 1][j];
                if ((j - coins.get(i - 1)) >= 0) {
                    dp[i][j] += dp[i][j - coins.get(i - 1)];
                }
            }
        }
        return dp[n][sum];
    }
    static long countMaxSp(int coins[], int n, int sum) {//T->O(N*sum),S->O(sum)
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= sum; j++)
                dp[j] += dp[j - coins[i]];

        return dp[sum];
    }
}
