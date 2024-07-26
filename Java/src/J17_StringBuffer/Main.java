package J17_StringBuffer;

import java.util.Random;
import java.util.Arrays;
import java.text.DecimalFormat;
// learning how to work with large string.
// String Buffer is mutable seq of characters, efficient, thread safe(slower)
// String Builder is not thread safe(faster)

public class Main {
    public static void main(String[] args) {
        // constructor 1
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());

        sb.append("WeMakeDevs");
        sb.append(" is nice!");
//        sb.insert(2, " Rahul ");
        System.out.println(sb);
        sb.replace(1, 5, " Rahul ");   //Rahul cover 1 to 4 index
        System.out.println(sb);
        sb.delete(1, 5);         //deleting index 1 to 4
        System.out.println(sb);
        sb.reverse();

        // constructor 2
        StringBuffer sb2 = new StringBuffer("Shivam Sahu");
        //System.out.println(sb2.capacity());
        // constructor 3
        StringBuffer sb3 = new StringBuffer(30);
        //System.out.println(sb3.capacity());

//        String str = sb.toString();
//        System.out.println(str);

        //Random String call
        int n = 20;
        String name = RandomString.generate(n);
        System.out.println(name);

        // remove whitespaces
        String sentence = "Hi h   hjh  hjkso  siowi     w ";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s", ""));

        // split
        String arr = "Kunal,Apoorv,Rahul,Snehal";
        String[] names = arr.split(",");
        System.out.println(Arrays.toString(names));

        // rounding off
        DecimalFormat df = new DecimalFormat("00.0000");
        System.out.println(df.format(7.29));
    }
}