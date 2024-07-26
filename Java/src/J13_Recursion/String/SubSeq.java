package J13_Recursion.String;
import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
//        subSeq("","abc");
//        System.out.println(subSeqRet("","abc"));
//        System.out.println(subSeqP("","abc",new ArrayList<>()));
        subSeqAscii("","ab");
        System.out.println(subSeqAsciiRet("","ab"));
    }
    static void subSeq(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch = up.charAt(0);
        subSeq(p+ch,up.substring(1));
        subSeq(p,up.substring(1));
    }
    static ArrayList<String> subSeqRet(String p, String up){
        if(up.isEmpty() ){
            ArrayList<String> list = new ArrayList<>();
            if(!p.isEmpty()) {
                list.add(p);
            }
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeqRet(p+ch,up.substring(1));
        ArrayList<String> right = subSeqRet(p,up.substring(1));
        left.addAll(right);
        return left;
    }
    static ArrayList<String> subSeqP(String p, String up,ArrayList<String> list){
        if(up.isEmpty() ){
            if(!p.isEmpty()) {
                list.add(p);
            }
            return list;
        }
        char ch = up.charAt(0);
        subSeqP(p+ch,up.substring(1),list);
        subSeqP(p,up.substring(1),list);
        return list;
    }
    static void subSeqAscii(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch = up.charAt(0);
        subSeqAscii(p+ch,up.substring(1));
        subSeqAscii(p,up.substring(1));
        subSeqAscii(p +(ch+0),up.substring(1));
    }
    static ArrayList<String> subSeqAsciiRet(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subSeqAsciiRet(p+ch,up.substring(1));
        ArrayList<String> second = subSeqAsciiRet(p,up.substring(1));
        ArrayList<String> third = subSeqAsciiRet(p+(ch+0),up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }
}
