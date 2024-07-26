package J14_DP.D1_KnapSack01;
import java.util.Arrays;

public class K5_MinDiffSubSum {
    public static void main(String[] args) {
        int arr[] = { 2,3,6};
        System.out.println(findMinRec(arr,arr.length));
        System.out.println(findMinMemo(arr,arr.length));
        System.out.println(findMinBU(arr,arr.length));
        System.out.println(findMinSp(arr,arr.length));
    }
    public static int findMinRec(int arr[], int n) {
        int sumTotal = 0;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];
        return process(arr, n, 0, sumTotal);//abs(s1-s2)=min
    }
    public static int process(int arr[], int n, int sumCalculated, int sumTotal) {
        if (n == 0) {
            return Math.abs(sumTotal - 2 * sumCalculated);
        }
        return Math.min(process(arr, n - 1, sumCalculated + arr[n - 1],
                        sumTotal), process(arr, n - 1, sumCalculated, sumTotal));
    }
    public static int findMinMemo(int[] arr, int n) {
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        // Create a memoization table initialized with -1
        int[][] dp = new int[n + 1][totalSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function 'f'
        return f(0, 0, arr, n, totalSum, dp);
    }
    public static int f(int idx,int sum,int[] arr,int n,int totalSum,int[][] dp){
        if (idx == n) {
            return Math.abs(totalSum - 2*sum);
        }
        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }
        int pick = f(idx + 1, sum + arr[idx], arr, n, totalSum, dp);
        int notPick = f(idx + 1, sum, arr, n, totalSum, dp);
        return dp[idx][sum] = Math.min(pick, notPick);
    }
    static int findMinBU(int arr[], int n) {//T->O(n*sum),O->O(n*sum)
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }
    static int findMinSp(int arr[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        int y = sum / 2 + 1;
        // dp[i] gives whether is it possible to get i as
        // sum of elements dd is helper variable we use dd
        // to ignoring duplicates
        boolean dp[] = new boolean[y], dd[]
                = new boolean[y];

        // Initialising dp and dd
        for (int i = 0; i < y; i++) {
            dp[i] = dd[i] = false;
        }

        // sum = 0 is possible
        dp[0] = true; // let dp array is used for storing
        // previous values and dd array is
        // used to store current values
        for (int i = 0; i < n; i++) {
            // updating dd[k] as true if k can be formed
            // using elements from 1 to i+1
            for (int j = 0; j + arr[i] < y; j++) {
                if (dp[j])
                    dd[j + arr[i]] = true;
            }
            // updating dd
            for (int j = 0; j < y; j++) {
                if (dd[j])
                    dp[j] = true;
                dd[j] = false;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (dp[i])
                return (sum - 2 * i);
        }
        return 0;
    }
}
