package J5_function;

import java.util.Scanner;

public class F3_ReturnString {
    public static void main(String[] args) {
//        System.out.println(greet());
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your Name:");
        String name = s.next();
        String personalised =myGreet(name);
        System.out.println(personalised);
        System.out.println(greet());
    }

    static String myGreet(String name) {
        String message = "Hello " + name;
        return message;
    }

    static String greet(){
        String greeting ="How are you";
        return greeting;
    }
}
