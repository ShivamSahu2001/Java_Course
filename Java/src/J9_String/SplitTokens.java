package J9_String;
import java.util.Scanner;
public class SplitTokens {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        s=s.trim();
        if(s.length()==0){
            System.out.println(0);
            return;
        }String[] token=s.split("[^a-zA-Z]+");
        System.out.println(token.length);
        for(String word:token){
            System.out.println(word);
        }
    }
}
