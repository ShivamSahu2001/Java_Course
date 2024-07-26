package J13_Recursion.Array;

public class R3_reverseNumbers {
    public static void main(String[] args) {
        //reverse(1231465);
//          reverse1(12345);
//          System.out.println(sum);
        System.out.println(reverse2(123456));
//        System.out.println(palindrome(1221));
    }
    static void reverse(int n){
        if (n==0){
            return;
        }
        System.out.print(n%10);
        reverse(n/10);
    }

    static int sum=0;
    static void reverse1(int n){
        if (n==0){
            return;
        }
        int rem =n%10;
        sum =sum *10+rem;
        reverse1(n/10);
    }

    static int reverse2(int n){
        int digits = (int)(Math.log10(n));
        System.out.println(digits);
        return helper(n,digits);
    }
    private static int helper(int n, int digits){
        if (n%10 == n){
            return n;
        }
        int rem = n%10;
        return rem * (int)(Math.pow(10,digits)) + helper(n/10,digits-1);
    }

    static boolean palindrome(int n){
        return n == reverse2(n);
    }
}
