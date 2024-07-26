package J9_String;

import java.util.Scanner;
         //return String.format("%.2f",sum);
public class PlaceHolder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        float a=453.1274f;
//        System.out.printf("Formatted number is %.2f",a);
//        System.out.println();
//        System.out.printf("Pie : %.3f",Math.PI);
//        System.out.println();
//        System.out.printf("Hello my name is %s and I am %s","Shivam","very Smart.");
        for(int i=0;i<3;i++){
            String s1=s.next();
            int x=s.nextInt();
            System.out.printf("%-15s%03d\n",s1,x);  //-15 means left justified
        }
//        java 100
//        cpp 65
//        python 50
    }
}
//  %c - Character
//  %d - Decimal number (base 10)
//  %e - Exponential floating-point number
//  %f - Floating-point number
//  %i - Integer (base 10)
//  %o - Octal number (base 8)
//  %s - String
//  %u - Unsigned decimal (integer) number
//  %x - Hexadecimal number (base 16)
//  %t - Date/time
//  %n - Newline
