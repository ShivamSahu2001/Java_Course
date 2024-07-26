package J14_DP.D1_Basic;
import java.util.*;
//https://bit.ly/3JPcoOx
public class B3_FrogJump {
    public static void main(String args[]) {
        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(FrogJumpMemo(n-1,height,dp));
        int dp1[]=new int[n];
        System.out.println(FrogJumpBU(height,n,dp1));
        System.out.println(FrogJumpSp(height,n));
    }
    static int FrogJumpMemo(int ind, int[] height, int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne= FrogJumpMemo(ind-1, height,dp)+ Math.abs(height[ind]-height[ind-1]);
        if(ind>1)
            jumpTwo = FrogJumpMemo(ind-2, height,dp)+ Math.abs(height[ind]-height[ind-2]);
        return dp[ind]=Math.min(jumpOne, jumpTwo);
    }
    static int FrogJumpBU(int[] height,int n,int[] dp1){
        dp1[0]=0;
        for(int ind=1;ind<n;ind++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne= dp1[ind-1] + Math.abs(height[ind]-height[ind-1]);
            if(ind>1)
                jumpTwo = dp1[ind-2] + Math.abs(height[ind]-height[ind-2]);

            dp1[ind]=Math.min(jumpOne, jumpTwo);
        }
        return dp1[n-1];
    }
    static int FrogJumpSp(int[] height,int n){
        int prev=0;
        int prev2=0;
        for(int i=1;i<n;i++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne= prev + Math.abs(height[i]-height[i-1]);
            if(i>1) {
                jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);
            }int cur_i=Math.min(jumpOne, jumpTwo);
            prev2=prev;
            prev=cur_i;
        }
        return prev;
    }
}
