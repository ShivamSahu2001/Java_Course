package J7_Searching;
//744  https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class S7_NextGreatestLetter {
    public static void main(String[] args) {
        char[] letters={'c','f','j'};
        char target ='j';
        System.out.println(nextGreatestLetter(letters,target));
    }
    static char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end=letters.length-1;
        while(start<=end){
            int mid =start +(end-start)/2;
            if(target<letters[mid]){
                end=mid-1;
            }
            else {
                start=mid+1;
            }

        }
        return letters[start % letters.length];
    }
}
