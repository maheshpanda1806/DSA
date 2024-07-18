import java.util.HashMap;

public class LongestSubArrayWithoutRepeatingCharacters {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
    public static void lengthOfLongestSubstring(String s){
        HashMap<Character,Integer> mpp = new HashMap<>();
        int i =0;
        int len = 0;
        int maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
             char ch = s.charAt(j);
            if (!mpp.containsKey(ch)) {
                mpp.put(ch, j);
            }else{
                i = Math.max(mpp.get(ch) + 1, i);
                
                mpp.put(ch,j);
            }
            len = j-i+1;
            maxLen = Math.max(len, maxLen);
        }
       System.out.println("MaxL  en  "+ maxLen);
    }
}
