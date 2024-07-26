package J14_DP.D1_Basic;

public class B1_FibonaciiDP {
    public static void main(String[] args) {
        System.out.println(fibMemo(50));
        System.out.println(fibBU(50));
        System.out.println(fibSp(50));
    }
    static long fibMemo(int n){//T->O(n),S->O(2n)
        long[] dp = new long[n+1];
        for (int i = 0; i <=n; i++) {
            dp[i]=-1;
        }
        return fib(n,dp);
    }
    // Bottom up approch
    static long fib(int n, long[] dp){
        if(n==0 || n==1){
            dp[n] =n;
            return dp[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] =fib(n-1,dp)+fib(n-2,dp);
        return dp[n];
    }
    //BOTTOM UP APPROCH
    static long fibBU(int n){
        long[] storage = new long[n+1];
        storage[0]=0;
        storage[1]=1;
        for (int i = 2; i <=n ; i++) {
            storage[i]=storage[i-1]+storage[i-2];
        }
        return storage[n];
    }
    static long fibSp(int n){//T->O(n),S->O(1)
        long prev2 = 0;
        long prev = 1;
        for (int i = 2; i <=n; i++) {
            long curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}
