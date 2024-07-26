package J14_DP.D1_KnapSack01;

public class K4_CountEqualSubSum {
    public static void main(String[] args) {
        int[] arr ={3, 3, 3, 3};
        System.out.println(countSubSumBU(arr,arr.length,6));
        System.out.println(countSubSumSpace(arr,arr.length,6));
    }
    static int countSubSumBU(int a[], int n, int sum) {//T->O(sum*n),C->O(sum*n)
        int dp[][] = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= sum; j++) {
                if (a[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
    static int countSubSumSpace(int arr[], int n, int val) {//T->O(sum*n),C->O(sum)
        int[] LastState = new int[val + 1];
        LastState[0] = 1;
        if (arr[0] <= val) {
            LastState[arr[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            int[] PresentState = new int[val + 1];
            PresentState[0] = 1;
            for (int j = 1; j <= val; j++) {
                int notPick = LastState[j];
                int pick = 0;
                if (arr[i] <= j)
                    pick = LastState[j - arr[i]];
                PresentState[j] = pick + notPick;
            }
            LastState = PresentState;
        }
        return LastState[val];
    }
}
