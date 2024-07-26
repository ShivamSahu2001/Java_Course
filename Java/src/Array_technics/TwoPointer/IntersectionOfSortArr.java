package Array_technics.TwoPointer;
import java.util.*;
public class IntersectionOfSortArr {
    public static void main(String[] args) {
        int A[]= {1,2,3,3,4,5,6,7};
        int B[]= {3,3,4,4,5,8};
        System.out.println(bruteMethod(A,B));
        ArrayList<Integer> ans= intersectionOfArrays(A,B);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
    public static ArrayList<Integer> bruteMethod(int[] A, int[] B){//T-> O(A*B), S-> O(n)

        ArrayList<Integer> ans=new ArrayList<>();

        // to maintain visited
        int visited[]=new int[B.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {

                if (A[i] == B[j] && visited[j] == 0) {

                    //if element matches and has not been matched with any other before
                    ans.add(B[j]);
                    visited[j] = 1;

                    break;
                } else if (B[j] > A[i]) break;
                //because array is sorted , element will not be beyond this
            }
        }
        return ans;
    }
    public static ArrayList<Integer> intersectionOfArrays(int[] A, int[] B){//T->O(n),S->O(1)

        // Declare ans array.
        ArrayList<Integer> ans=new ArrayList<>();

        int i = 0, j = 0;

        // to traverse the arrays
        while (i < A.length && j < B.length) {

            //if current element in i is smaller
            if (A[i] < B[j]) {
                i++;
            } else if (B[j] < A[i]) {
                j++;
            } else {

                //both elements are equal
                ans.add(A[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
}
