package J9_String;

public class ReverseString {
    public static void main(String[] args) {
        String str="Shivam";
        //method1(str);
        System.out.println(method2(str));
    }
    public static void method1(String str){
        int n =str.length()-1;
        while( n >= 0){
            char ch = str.charAt(n);
            System.out.print(ch);
            n--;
        }
    }
    public static String method2(String str){
        String str1 ="";
        for (int i = str.length()-1; i >=0; i--) {
            str1 +=str.charAt(i);
        }return str1;
    }
}
