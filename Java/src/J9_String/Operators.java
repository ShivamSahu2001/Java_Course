package J9_String;

import java.util.ArrayList;

public class Operators {
    // Operators overloding -> operators giving more functionalities
    // The Operators + in java is only defined for primitive
    // & only when any one of these values is a string
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        System.out.println("a" + "b");
        System.out.println((char)('a' + 3));
        System.out.println("a" + 1);//call Rapper class
        //integer will be converted to Integer that will call toString()
        //this is same as after a few steps: "a" + "1"
        System.out.println("Shivam"+ new ArrayList<>());
        System.out.println("Shivam"+ new Integer(56));
         //+ in java you can use only premitive & complex object aswell
        //but the only condition is this atleast one of these object of String type
        String ans=new Integer(56)+" "+ new ArrayList<>();
        System.out.println(ans);
    }
}
