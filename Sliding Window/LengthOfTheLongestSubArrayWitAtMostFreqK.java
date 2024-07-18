import java.util.*;
public class LengthOfTheLongestSubArrayWitAtMostFreqK {
    
}
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l=0,r=0,maxlen=0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        
        for(r=0;r<nums.length;r++){
            int val = nums[r];
            mpp.put(val,mpp.getOrDefault(val,0)+1);
            while(mpp.getOrDefault(val,0)>k){
               mpp.put(nums[l],mpp.get(nums[l])-1);
               if(mpp.get(nums[l])==0) mpp.remove(nums[l]);
               l++;
            }
            if(mpp.getOrDefault(val,0)<=k){
                    maxlen=Math.max(maxlen,r-l+1);
            }
        }
        return maxlen;
    }
}