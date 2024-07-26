package J9_String;

import java.util.Scanner;

public class Confusion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        A.toLowerCase();
        String reverse="";
        for (int i = A.length()-1; i>=0; i--) {
            reverse+=A.charAt(i);
        }
        String m="shivamsahu";
        String n="shivamsahu";
        System.out.println(m==n);
        System.out.print(A + "\n");
        System.out.println(reverse);
        System.out.println(A==reverse);
        System.out.println(reverse);
        if(A==reverse){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        System.out.println(A.hashCode());
        System.out.println(reverse.hashCode());
        System.out.println(A.getClass().getSimpleName());
        System.out.println(reverse.getClass().getSimpleName());

    }
}
