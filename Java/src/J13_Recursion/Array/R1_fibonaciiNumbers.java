package J13_Recursion.Array;
//Types of Recurrence Relation -> Linear RR, Divide & Conquer RR
import java.util.Scanner;
public class R1_fibonaciiNumbers {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n = s.nextInt();
        Nto1(n);
        System.out.println();
        int ans= fibNumbers(n);
        System.out.println(ans);
    }
    static void Nto1(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        Nto1(n-1);
        System.out.print(n+" ");
    }

    static int fibNumbers(int n){
        if(n<2) {  //n==0 || n==1
            return n;
        }
        return fibNumbers(n-1)+fibNumbers(n-2);
    }
    static int fab2(int n){
        if(n<2){
            return n;
        }
        int i = 0;
        int j = 1;
        int ans = 0;
        for (int k = 1; k < n; k++) {
            ans = i + j;
            i=j;
            j= ans;
        }
        return ans;
    }
    static void fabPrint(int n){
        while(n<2 && n>-1){
            System.out.print(n+" ");
            n--;
        }
        int i = 0;
        int j = 1;
        int ans = 0;
        System.out.print(ans+" ");
        for (int k = 0; k < n; k++) {
            ans = i + j;
            i=j;
            System.out.print(j+" ");
            j= ans;
        }
    }
}
