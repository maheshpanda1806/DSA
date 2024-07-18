public class CountSubarraysWithAtLeastKMax {
    
}
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        long n = nums.length;
        long count = 0;
        int l=0,r=0;
        long countMax = 0;
        for(r=0;r<nums.length;r++){
            if(nums[r]==max) countMax++;
            while(countMax>=k){
                count+= n-(long)r;
                if(nums[l]==max) countMax--;
                l++;
            }
        }
        return count;
    }
}