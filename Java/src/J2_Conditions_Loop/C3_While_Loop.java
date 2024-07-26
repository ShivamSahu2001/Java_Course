package J2_Conditions_Loop;
import java.util.Scanner;

public class C3_While_Loop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(isPrime(n));//alt enter shortcut for creating functions
        System.out.println(isArmstrong(n));
        for (int i = 100; i < 1000 ; i++) {
            if(isArmstrong(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println(reverse(n));
    }
    //print all the 3 digits armstrong numbers
    static boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            n /=10;
            sum = sum + rem*rem*rem;
        }
        return sum == original;
    }

    static boolean isPrime(int n) {
        if(n<=1){
            return false;
        }
        int c = 2;
        while(c * c <= n){
            if (n % c == 0){
                return false;
            }
            c++;
        }
        return c * c > n;
//        if(c * c > n){
//            return true;
//        }
//        return false;
    }
    static int reverse(int n) {
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            n /= 10;
            ans = ans * 10 +rem;
        }
        return ans;
    }
}
