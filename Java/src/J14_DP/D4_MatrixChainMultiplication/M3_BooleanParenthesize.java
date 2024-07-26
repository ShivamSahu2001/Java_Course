package J14_DP.D4_MatrixChainMultiplication;
import java.util.Arrays;

public class M3_BooleanParenthesize {
    public static void main(String[] args) {
        char[] symbols = "TTFT".toCharArray();
        char[] operators = "|&^".toCharArray();
        int n = symbols.length;
        System.out.println(countWaysBU(symbols,operators,n));
        String symbol = "TTFT";
        String operator = "|&^";
        StringBuilder S = new StringBuilder();
        int j = 0;
        for (int i = 0; i < symbol.length(); i++) {
            S.append(symbol.charAt(i));
            if (j < operator.length())
                S.append(operator.charAt(j++));
        }
        // We obtain the string  T|T&F^T
        int N = S.length();
        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and
        // (T|((T&F)^T))
        System.out.println(countWaysMemo(N, S.toString()));
    }
    static int countWaysBU(char symb[], char oper[], int n) {//T->O(n3),S->O(n2)
        int F[][] = new int[n][n];
        int T[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            F[i][i] = (symb[i] == 'F') ? 1 : 0;
            T[i][i] = (symb[i] == 'T') ? 1 : 0;
        }
        for (int gap = 1; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                T[i][j] = F[i][j] = 0;
                for (int g = 0; g < gap; g++) {
                    // Find place of parenthesization
                    // using current value of gap
                    int k = i + g;
                    // Store Total[i][k]
                    // and Total[k+1][j]
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k + 1][j] + F[k + 1][j];
                    if (oper[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);
                    }
                    if (oper[k] == '|') {
                        F[i][j] += F[i][k] * F[k + 1][j];
                        T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);
                    }
                    if (oper[k] == '^') {
                        T[i][j] += F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        return T[0][n - 1];
    }
    public static int countWaysMemo(int N, String S) {//T->O(n3),S->O(n2)
        int dp[][][] = new int[N + 1][N + 1][2];
        for (int row[][] : dp) {
            for (int col[] : row) {
                Arrays.fill(col, -1);
            }
        }
        return parenthesis_count(S, 0, N - 1, 1, dp);
    }

    public static int parenthesis_count(String str, int i, int j, int isTrue,
                                        int[][][] dp) {
        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue == 1) {
                return (str.charAt(i) == 'T') ? 1 : 0;
            }
            else {
                return (str.charAt(i) == 'F') ? 1 : 0;
            }
        }
        if (dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];

        int temp_ans = 0;
        int leftTrue, rightTrue, leftFalse, rightFalse;

        for (int k = i + 1; k <= j - 1; k = k + 2) {
            if (dp[i][k - 1][1] != -1)
                leftTrue = dp[i][k - 1][1];
            else {
                // Count number of True in left Partition
                leftTrue = parenthesis_count(str, i, k - 1,
                        1, dp);
            }
            if (dp[i][k - 1][0] != -1)
                leftFalse = dp[i][k - 1][0];
            else {
                // Count number of False in left Partition
                leftFalse = parenthesis_count(str, i, k - 1,
                        0, dp);
            }
            if (dp[k + 1][j][1] != -1)
                rightTrue = dp[k + 1][j][1];
            else {
                // Count number of True in right Partition
                rightTrue = parenthesis_count(str, k + 1, j,
                        1, dp);
            }
            if (dp[k + 1][j][0] != -1)
                rightFalse = dp[k + 1][j][0];
            else {
                // Count number of False in right Partition
                rightFalse = parenthesis_count(str, k + 1, j, 0, dp);
            }

            // Evaluate AND operation
            if (str.charAt(k) == '&') {
                if (isTrue == 1) {
                    temp_ans = temp_ans + leftTrue * rightTrue;
                }
                else {
                    temp_ans = temp_ans + leftTrue * rightFalse
                            + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            }
            // Evaluate OR operation
            else if (str.charAt(k) == '|')
            {
                if (isTrue == 1) {
                    temp_ans = temp_ans + leftTrue * rightTrue
                            + leftTrue * rightFalse + leftFalse * rightTrue;
                }
                else {
                    temp_ans = temp_ans + leftFalse * rightFalse;
                }
            }

            // Evaluate XOR operation
            else if (str.charAt(k) == '^')
            {
                if (isTrue == 1)
                {
                    temp_ans = temp_ans + leftTrue * rightFalse
                            + leftFalse * rightTrue;
                }
                else {
                    temp_ans = temp_ans + leftTrue * rightTrue
                            + leftFalse * rightFalse;
                }
            }
            dp[i][j][isTrue] = temp_ans;
        }
        return temp_ans;
    }
}
