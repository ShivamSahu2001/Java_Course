package Array_technics.SWindow;
import java.util.*;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class S4_LSSWithoutRep {
    public static void main(String[] args) {
        String str = "takeUforward";
        System.out.println(LSubStringBrute(str));
        System.out.println(LSubStringBetter(str));
        System.out.println(LSubStringOpt(str));
    }
    static int LSubStringBrute(String str){//T-O(N^2),S-O(N)
        if(str.length() == 0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> se = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if (se.contains(str.charAt(j))) {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(str.charAt(j));
            }
        }
        return maxans;
    }
    static int LSubStringBetter(String str) {//T-O(2N),S-O(N)
        if(str.length()==0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        Set < Character > set = new HashSet < > ();
        int l = 0;
        for (int r = 0; r < str.length(); r++){
            if (set.contains(str.charAt(r))){
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }
    static int LSubStringOpt(String s) {//T-O(n),S-O(n)
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
