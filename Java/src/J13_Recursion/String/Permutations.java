package J13_Recursion.String;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        permutation("","abc");
        System.out.println(permutationList("","abc"));
        System.out.println(permutationCount("","abcde"));
        System.out.println(permutationCount1("","abcde",0));
    }
    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            permutation(f + ch +s,up.substring(1));
        }
    }
    static ArrayList<String> permutationList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(permutationList(f + ch +s,up.substring(1)));
        }
        return ans;
    }
    static int permutationCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count = count + permutationCount(f + ch +s,up.substring(1));
        }
        return count;
    }
    static int permutationCount1(String p, String up,int count){
        if(up.isEmpty()){
            return count+1;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count = permutationCount1(f + ch +s,up.substring(1),count);
        }
        return count;
    }
}
