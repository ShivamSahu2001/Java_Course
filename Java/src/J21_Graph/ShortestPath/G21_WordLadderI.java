package J21_Graph.ShortestPath;
import java.util.*;
import java.lang.*;
import java.io.*;
class Pair5 {
    String first;
    int second;
    Pair5(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
public class G21_WordLadderI {
    public static void main(String[] args) throws IOException {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        int ans = wordLadderLength(startWord, targetWord, wordList);
        System.out.print(ans);
        System.out.println();
    }
    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue < Pair5 > q = new LinkedList < > ();
        q.add(new Pair5(startWord, 1));
        Set < String > st = new HashSet < String > ();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }
        st.remove(startWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (word.equals(targetWord)) return steps;
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair5(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
