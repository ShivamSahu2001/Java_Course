package J9_String;

import java.util.Arrays;
public class Stringmethod {
    //1- String Pool
    //2- Immutability
    public static void main(String[] args) {
        char[] arr ={'f','b','g','j'};
        String str1 ="Coding";
        System.out.println(Arrays.toString(str1.toCharArray()));
        String str2 =" Ninjas";
        String str3 =new String("Coding");
        //System.out.println(str1.length());
//        System.out.println(str1.charAt(3));
//        System.out.println(str1 +str2);
//        System.out.println(str1.concat(str3));
          //System.out.println(str1.equals(str3));
       System.out.println(str1.compareTo(str3));
    //System.out.println(str1.contains(str3));
       // System.out.println(str1==str3);
        String name = "Shivam Sahu";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());
        System.out.println(name);
        System.out.println(name.indexOf('a'));
        //System.out.println("  Shivam  ".strip());
        System.out.println(Arrays.toString(name.split(" ")));

        //Substring fuction
        String substr =str1.substring(1,6);
        System.out.println(substr);
        System.out.println(substr.length());
        String substr1 =str1.substring(6);
        System.out.println(substr1);
        System.out.println(substr1.length());

    }
}
