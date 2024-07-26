package J5_function;
//function-block of code
import java.util.Scanner;

public class F1_CallingFunction {
    public static void main(String[] args) {
        System.out.println(sum());
//      System.out.println(sum2());
//        System.out.println(sum3(20,42));
    }
    static int sum(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first number:");
        int num1 = s.nextInt();
        System.out.println("Enter second number:");
        int num2 = s.nextInt();
        int sum =num1+num2;
        return sum;
        //System.out.println("The sum = " + sum);
    }
    static int sum2(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first number:");
        int num1 = s.nextInt();
        System.out.println("Enter second number:");
        int num2 = s.nextInt();
        int sum =num1+num2;
        return sum;
//      System.out.println("This will never Execute");
    }
    static int sum3 (int a, int b){
        int sum =a+b;
        return sum;
    }

}

