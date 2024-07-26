package J14_DP.D1_KnapSack01;

import java.util.Arrays;

public class K2_SubSetSum {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 2 };
        int sum = 11;
        System.out.println(isSubsetSum(arr,arr.length,sum));
        System.out.println(subsetSumMemo(arr,arr.length,sum));
        System.out.println(isSubsetSumBU(arr,arr.length,sum));
        System.out.println(isSubsetSumSP(arr,arr.length,sum));
    }
    static boolean isSubsetSum(int arr[], int n, int sum) {//T->O(2n),O->O(n)
        if (sum == 0) {
            return true;
        }if (n == 0) {
            return false;
        }if (arr[n - 1] > sum) {
            return isSubsetSum(arr, n - 1, sum);
        }
        return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }
    static int subsetSumMemo(int arr[], int n, int sum) {
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        if (sum == 0) {
            return 1;
        }if (n == 0) {
            return 0;
        }if (dp[n][sum] != -1) {
            return dp[n][sum];
        }if (arr[n - 1] > sum) {
            return dp[n][sum] = subsetSumMemo(arr, n - 1, sum);
        }else {
                return dp[n][sum] = Math.max(subsetSumMemo(arr,n-1,sum-arr[n-1]),subsetSumMemo(arr,n-1,sum));
        }
    }
    static boolean isSubsetSumBU(int arr[], int n, int sum) {//T->O(sum * n),S->O(sum * n)
//        boolean subset[][] = new boolean[sum + 1][n + 1];
//        for (int i = 0; i <= n; i++) {
//            subset[0][i] = true;
//        }for (int i = 1; i <= sum; i++) {
//            subset[i][0] = false;
//        }for (int i = 1; i <= sum; i++) {
//            for (int j = 1; j <= n; j++) {
//                subset[i][j] = subset[i][j - 1];
//                if (i >= arr[j - 1]) {
//                    subset[i][j] = subset[i][j] || subset[i - arr[j - 1]][j - 1];
//                }
//            }
//        }
//        return subset[sum][n];
        boolean[][] dp=new boolean[n+1][sum+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }for (int j = 1; j < sum+1; j++) {
            dp[0][j]=false;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j]=dp[i-1][j];
                if(arr[i-1] <=j){
                    dp[i][j]=dp[i][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
    static boolean isSubsetSumSP(int[] set, int n, int sum) {//T->O(sum * n),S->O(sum)
        boolean[] prev = new boolean[sum + 1];//wrong output

        // If the sum is 0, the answer is true
        for (int i = 0; i <= n; i++)
            prev[0] = true;

        // If the sum is not 0 and the set is empty,
        // the answer is false
        for (int i = 1; i <= sum; i++)
            prev[i] = false;

        // curr array to store the current row result generated
        // with the help of the prev array
        boolean[] curr = new boolean[sum + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < set[i - 1])
                    curr[j] = prev[j];
                if (j >= set[i - 1])
                    curr[j] = prev[j] || prev[j - set[i - 1]];
            }
            // now curr becomes prev for (i + 1)th element
            prev = Arrays.copyOf(curr, curr.length);
        }

        return prev[sum];
    }
}
