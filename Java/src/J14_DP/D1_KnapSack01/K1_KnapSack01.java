package J14_DP.D1_KnapSack01;
public class K1_KnapSack01 {
    public static void main(String[] args) {
        int[] wt = new int[]{30,10, 20};
        int[] val = new int[]{120,60, 100};
        int n = wt.length;
        System.out.println(knapSackRec(wt,val,50,n));
        System.out.println(knapSackMemoization(50,wt,val,n));
        System.out.println(knapSackBottomUp(50,wt,val,n));
        System.out.println(knapSackBUSpace(50,wt,val,n));
    }
    static int knapSackRec(int[] wt, int[] val, int w, int n){  //1 //TC-O(2^N),SC-O(N)
        if(n ==0 || w ==0){
            return 0;
        }
        if(wt[n-1]<=w){
            return Math.max(val[n-1] + knapSackRec(wt,val,w-wt[n-1],n-1), knapSackRec(wt,val,w,n-1));
        }
        else{
            return knapSackRec(wt,val,w,n-1);
        }
    }
    static int max(int a, int b) { return (a > b) ? a : b; }////TC->O(N * W),SC->O(N*W)+O(N)
    static int knapSackMemoization(int w, int wt[], int val[], int n) {//Top down
        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return knapSack(w, wt, val, n, dp);
    }
    static int knapSack(int w, int wt[], int val[], int n, int[][] dp) {
        if (n == 0 || w == 0) {
            return 0;
        }if (dp[n][w] != -1){
            return dp[n][w];
        }if (wt[n - 1] > w) {
            return dp[n][w] = knapSack(w, wt, val, n - 1, dp);
        }else
            return dp[n][w] = max((val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1, dp))
                    , knapSack(w, wt, val, n - 1, dp));
    }
    static int knapSackBottomUp(int W, int wt[], int val[], int n){//TC-O(N * W),SC-O(N*W)
       // int i, w;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }else if (wt[i - 1] <= w) {
                    dp[i][w] = max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                }else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }
    static int knapSackBUSpace(int W, int wt[], int val[], int n) {//TC-O(N * W),SC-O(W)
        int[] dp = new int[W + 1];
        for (int w = 1; w < n + 1; w++) {
            for (int j = W; 0<=j; j--) {
                if (wt[w - 1] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - wt[w - 1]] + val[w - 1]);
                }
            }
        }
        return dp[W];
    }
}
