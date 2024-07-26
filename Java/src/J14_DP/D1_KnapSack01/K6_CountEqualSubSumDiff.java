package J14_DP.D1_KnapSack01;

public class K6_CountEqualSubSumDiff { //target sum
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 1, 2};
        System.out.println(countSubSumDiffBU(arr,5,1));
    }
    static int countSubSumDiffBU(int[] arr,int n, int diff){
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s +=arr[i];
        }
        int sum=(diff+s)/2;
        int dp[][] = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= sum; i++)
            dp[0][i] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] +
                            dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
