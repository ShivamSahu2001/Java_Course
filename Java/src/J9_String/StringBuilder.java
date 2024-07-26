package J9_String;

public class StringBuilder {
    public static void main(String[] args) {
        java.lang.StringBuilder builder =new java.lang.StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            builder.append(ch);
        }
        System.out.println(builder.toString());
        builder.deleteCharAt(0);
        builder.reverse();
        System.out.println(builder);
    }
}

