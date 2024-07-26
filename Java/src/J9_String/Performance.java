package J9_String;

public class Performance {
    public static void main(String[] args) {
        String series ="";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            System.out.println(ch);
            series +=ch; //0(n^2)so much memory wasted by creating new obj
        }
        System.out.println(series);
        //If one of the data type is string answer will be string
        //System.out.println("a" + 'b');
    }
}
