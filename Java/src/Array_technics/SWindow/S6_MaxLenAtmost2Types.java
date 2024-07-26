package Array_technics.SWindow;
import java.util.*;
// https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1
public class S6_MaxLenAtmost2Types {
    public static void main(String[] args) {
        int[] arr= {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(MaxLenBrute(arr));
        System.out.println(MaxLen(arr,2));
    }
    static int MaxLenBrute(int[] arr) {//T-O(n^2),S-O(1)
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> se = new HashSet<>();
            for (int j = i; j < arr.length; j++) {
                se.add(arr[j]);
                if(se.size() <=2){
                    maxLength = Math.max(maxLength,j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxLength;
    }
    static int MaxLen(int[] arr, int K) {//T->O(N), S->O(1)
        int i = 0,start = 0,len = 0;
        int n = arr.length;
        // Map to maintain size of sections
        Map<Integer, Integer> m = new HashMap<>();
        int maxx = 0;
        while (i < n) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
            len++;
            // If count of number is more than K
            if (m.size() > K) {  // while T->2(N)
                m.put(arr[start], m.get(arr[start]) - 1);
                len--;
                // If all occurrences of number is erased
                if (m.get(arr[start]) == 0) {
                    m.remove(arr[start]);
                }
                start++;
            }

            // Update the maximum numbers
            if (m.size() <= K) {
                maxx = Math.max(maxx, len);
            }
            i++;
        }
        // Return the output
        return maxx;
    }
}
