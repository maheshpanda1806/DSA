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


//more intutive 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r = 0;
        int l = 0;
        int n = s.length();
        HashMap<Character,Integer> mpp = new HashMap<>();
        int max = 0;
        while(r<n){
         char ch = s.charAt(r);
         mpp.put(ch,mpp.getOrDefault(ch,0)+1);
         //shrink
         while(mpp.get(ch)>1){
            char ch1 = s.charAt(l);
            mpp.put(ch1,mpp.getOrDefault(ch1,0)-1);
            if(mpp.get(ch1)==0) mpp.remove(ch1);
            l++;
         }

         max = Math.max(max,r-l+1);

         //expand
         r++;
        }
        return max;
    }
}
