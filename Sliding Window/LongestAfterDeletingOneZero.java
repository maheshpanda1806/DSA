public class LongestAfterDeletingOneZero {
    
}
class Solution {
    //This Question is Same as Slidig window pattern 2 longest subarray with atmost 1 zero 
    public int longestSubarray(int[] nums) {
      int len = 0;
      int l =0;
      int count =0;//zero count 
      for(int r=0;r<nums.length;r++){
        if(nums[r]==0) count++;
        while(count>1){//shrink
        if(nums[l]==0) count--;
        l++;
        }
        len = Math.max(len,r-l+1);
      }
      return len-1;
    }
}