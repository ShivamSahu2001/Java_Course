package J9_String;

import java.util.Scanner;

public class Stringinput {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        while(s.hasNext()){
//            //Iterating till input are there
//        }
//        String str= s.next();
//        System.out.println(str + " " + str.length());
//        int i = s.nextInt();
//        String str1= s.nextLine();
//        System.out.println(str1 + " " + str1.length());
        String str3 =s.nextLine();
        printChar(str3);

    }
    static void printChar(String str3){
        for (int i = 0; i < str3.length(); i++) {
            System.out.print(str3.charAt(i)+" ");
        }
    }

}
