package J14_DP.D1_Basic;
import java.util.Arrays;
//https://atcoder.jp/contests/dp/tasks/dp_b
public class B3_FrogJumpKSteps {
    public static void main(String[] args) {
        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int k = 2;
        System.out.println(FrogJumpRec(n-1,height,k));
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(FrogJumpMemo(n - 1, height, dp, k));
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        System.out.println(FrogJumpBU(n, height,dp,k));
    }
    static int FrogJumpRec(int index,int[] height,int k){//T->O(N*K),S->O(2N)
        if(index==0) {
            return 0;
        }
        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (index - j >= 0) {
                int jump = FrogJumpRec(index - j, height, k) + Math.abs(height[index] - height[index - j]);
                minSteps = Math.min(jump, minSteps);
            }
        }
        return minSteps;
    }
    static int FrogJumpMemo(int ind, int[] height, int[] dp, int k) {//T->O(N*K),S->O(N)
        if (ind == 0) {
            return 0;
        }if (dp[ind] != -1) {
            return dp[ind];
        }int mmSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = FrogJumpMemo(ind - j, height, dp, k) + Math.abs(height[ind] - height[ind - j]);
                mmSteps = Math.min(jump, mmSteps);
            }
        }
        return dp[ind] = mmSteps;
    }
    static int FrogJumpBU(int n, int[] height, int[] dp, int k){//T->O(N*K),S->O(N)
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1];
    }
}
