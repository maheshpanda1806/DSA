import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    class Solution {
    public int longestStrChain(String[] nums) {
        Arrays.sort(nums, Comparator.comparingInt(String::length));
        //List<String> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp =  new int[n];
      //  int[] hash = new int[n];
       
        int maxi =0;
        for(int i =0;i<n;i++){
            int max = -1;
            for (int j = 0; j <i; j++) {
                if(max==-1 && check(nums[i],nums[j])){
                    max = j;
                }else if(check(nums[i],nums[j]) && dp[j]>dp[max]){
                    max = j;
                }
            }
            if(max==-1) dp[i] = 1;
            else{
                 dp[i] = dp[max] + 1;
                
            }
             if(dp[i]>dp[maxi]) maxi = i;
        }
        
        int idx = maxi;

        

        //System.out.println(Arrays.toString(dp));
        return dp[maxi];
    }
    public static boolean check(String s1,String s2){
        if(s1.length()-s2.length()!=1) return false;

        int j =0;
        for(int i =0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(j)) j++;
            if(j==s2.length()) return true;
        }
        return j == s2.length();
    }
}
}
