package J14_DP.D4_MatrixChainMultiplication;
import java.util.*;
import java.util.Arrays;
public class M4_scrambledString {
    public static void main(String[] args) {
        String S1 = "coder";
        String S2 = "ocred";
        System.out.println(isScrambleRec(S1,S2));
        System.out.println(isScrambleMemo(S1,S2));
    }
    static boolean isScrambleRec(String S1, String S2){//T->O(2^k + 2^(n-k)),S->O(2^N)
        if (S1.length() != S2.length()) {
            return false;
        }
        int n = S1.length();
        if (n == 0) {
            return true;
        }
        if (S1.equals(S2)) {
            return true;
        }
//        char[] tempArray1 = S1.toCharArray();
//        char[] tempArray2 = S2.toCharArray();
//
//        // Checking condition for Anagram
//        Arrays.sort(tempArray1);
//        Arrays.sort(tempArray2);
//
//        String copy_S1 = new String(tempArray1);
//        String copy_S2 = new String(tempArray2);
//
//        if (!copy_S1.equals(copy_S2)) {
//            return false;
//        }
        for(int i = 1; i < n; i++) {
            if (isScrambleRec(S1.substring(0, i), S2.substring(0, i)) &&
                    isScrambleRec(S1.substring(i, n), S2.substring(i, n))) {
                return true;
            }
            if (isScrambleRec(S1.substring(n - i, n), S2.substring(0, i)) &&
                    isScrambleRec(S1.substring(0, n - i), S2.substring(i, n))) {
                return true;
            }
        }
        return false;
    }
    static HashMap<String, Boolean> mp = new HashMap<String, Boolean>();
    static boolean isScrambleMemo(String S1, String S2) {
        if (S1.length() != S2.length()) {
            return false;
        }
        int n = S1.length();
        if (n == 0) {
            return true;
        }
        if (S1.equals(S2)) {
            return true;
        }
        // Check for the condition of anagram
        String copy_S1 = S1, copy_S2 = S2;
        char[] t1 = copy_S1.toCharArray();
        char[] t2 = copy_S2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        copy_S1 = new String(t1);
        copy_S2 = new String(t2);

        if (!copy_S1.equals(copy_S2)) {
            return false;
        }
        String key = (S1 + " " + S2);
        if (mp.containsKey(key)) {
            return mp.get(key);
        }
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            if (isScrambleMemo(S1.substring(0, i), S2.substring(0, i))
                    && isScrambleMemo(S1.substring(i, n), S2.substring(i, n))) {
                flag = true;
                mp.put(key, flag);//store for future use
                return true;
            }
            if (isScrambleMemo(S1.substring(0, i), S2.substring(n - i, n))
                    && isScrambleMemo(S1.substring(i, n),
                    S2.substring(0, n - i))) {
                flag = true;
                mp.put(key, flag); //store for future use
                return true;
            }
        }
        mp.put(key, flag);
        return false;
    }
}
