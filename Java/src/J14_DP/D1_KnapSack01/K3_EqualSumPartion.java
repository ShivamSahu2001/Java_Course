package J14_DP.D1_KnapSack01;

import java.util.Arrays;

public class K3_EqualSumPartion {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 5,4};
        System.out.println(equalSumBU(arr,arr.length));
    }
    static boolean equalSumRec(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        if (sum % 2 != 0)
            return false;
        return process1(arr, n, sum / 2);//abs(s1-s2)=0
    }
    static boolean process1(int arr[], int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (arr[n - 1] > sum)
            return process1(arr, n - 1, sum);

        return process1(arr, n - 1, sum)
                || process1(arr, n - 1, sum - arr[n - 1]);
    }
    static int equalSumMemo(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }if (sum % 2 != 0) {
            return 0;
        }int dp[][] = new int[n + 1][sum + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }return process(arr, n, sum / 2, dp);
    }
    static int process(int arr[], int n, int sum, int[][] dp) {
        if (sum == 0) {
            return 1;
        }if (n == 0) {
            return 0;
        }if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        if (arr[n - 1] > sum) {
            return process(arr, n - 1, sum, dp);
        }if (process(arr, n - 1, sum, dp) != 0
                || process(arr, n - 1, sum - arr[n - 1], dp) != 0) {
            return dp[n][sum] = 1;
        }return dp[n][sum] = 0;
    }
    static boolean equalSumBU(int[] arr,int n){//T-O(sum * N),C- O(sum * N)
        int val=0;
        for (int i = 0; i < n; i++) {
            val +=arr[i];
        }
        if(val%2 !=0){
            return false;
        }
        int sum = val/2;
        boolean subset[][] = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= arr[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - arr[j - 1]][j - 1];
                }
            }
        }
        return subset[sum][n];
    }
    public static boolean findPartSpace(int arr[], int n) {//T-O(sum * N),O(sum)
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] part = new boolean[sum / 2 + 1];
        for (int i = 0; i <= sum / 2; i++) {
            part[i] = false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= arr[i]; j--) {
                if (part[j - arr[i]] == true || j == arr[i])
                    part[j] = true;
            }
        }
        return part[sum / 2];
    }
}
