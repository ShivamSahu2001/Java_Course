package J14_DP.D2_UnboundedKnapSack;
public class U1_UnboundedKnapSack { //Road cutting problem
    public static void main(String[] args) {
        int val[] = { 10, 30, 20 };
        int wt[] = { 5, 10, 15 };
        System.out.println(unboundKSackRec(wt,val,100,val.length));
        System.out.println(unboundedKSackMemo(100,wt,val,val.length));
        System.out.println(unboundedKSackBU(100,wt,val,val.length));
        System.out.println(unboundedKSackSp(100,val.length,val,wt));
    }
    static int unboundKSackRec(int[] wt, int[] val, int w, int n){  //1 //TC-O(2^N),SC-O(N)
        if(n ==0 || w ==0){
            return 0;
        }
        if(wt[n-1]<=w){
            return Math.max(val[n-1] + unboundKSackRec(wt,val,w-wt[n-1],n), unboundKSackRec(wt,val,w,n-1));
        }
        else{
            return unboundKSackRec(wt,val,w,n-1);
        }
    }
    static int unboundedKSackMemo(int w, int wt[], int val[], int n) {//Top down
        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return process(w, wt, val, n, dp);
    }
    static int process(int w, int wt[], int val[], int n, int[][] dp) {
        if (n == 0 || w == 0) {
            return 0;
        }if (dp[n][w] != -1){
            return dp[n][w];
        }if (wt[n - 1] > w) {
            return dp[n][w] = process(w, wt, val, n - 1, dp);
        }else
            return dp[n][w] = Math.max((val[n - 1] + process(w - wt[n - 1], wt, val, n , dp))
                    , process(w, wt, val, n - 1, dp));
    }
    static int unboundedKSackBU(int W, int wt[], int val[], int n){//TC-O(N * W),SC-O(N*W){
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                }else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i][w - wt[i - 1]], K[i - 1][w]);
                }else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[n][W];
    }
    static int unboundedKSackSp(int W, int n, int[] val, int[] wt) {
        int dp[] = new int[W + 1];
        // Fill dp[] using above recursive formula
        for(int i = 0; i <= W; i++){
            for(int j = 0; j < n; j++){
                if(wt[j] <= i){
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] +
                            val[j]);
                }
            }
        }
        return dp[W];
    }
}
