package J13_Recursion.Array;

public class R2_digitSumProduct {
    public static void main(String[] args) {
        System.out.println(sum(5230));
        System.out.println(prod(5402));
        System.out.println(factorial(5));
    }
    static int sum(int n){
        if(n==0){
            return 0;
        }
        return n%10 + sum(n/10);
    }
    static int prod(int n){
        if(n%10 == n){
            return n;
        }
        return n%10 * prod(n/10);
    }
    static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
