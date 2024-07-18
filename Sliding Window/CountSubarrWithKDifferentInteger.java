import java.util.*;
public class CountSubarrWithKDifferentInteger {
    
}
//LEETCODE HARD 992
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return (soln(nums,k)-soln(nums,k-1));
    }

    public int soln(int[] nums, int k) {
      if(k<0) return 0;
      int l =0;
      int r =0;
      HashMap<Integer,Integer> mpp =  new HashMap<>();//nums[i], frequency
      int count =0;
      
      for(r=0;r<nums.length;r++){
        mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
        if(mpp.size()<=k){
            //
        }else{
            while(mpp.size()>k){
                   mpp.put(nums[l],mpp.getOrDefault(nums[l],0)-1);
                   if(mpp.getOrDefault(nums[l],0)==0) mpp.remove(nums[l]);
                   l++;
            }
        }
         count+= r-l+1;
      }
      return count;
    }
}
//LEETCODE 2799
class Solution2 {
    public int countCompleteSubarrays(int[] nums) {
      HashSet<Integer> st = new HashSet<>();
      for(int i : nums){
        st.add(i);
      }   
      return subarraysWithKDistinct(nums,st.size());
    }
     public int subarraysWithKDistinct(int[] nums, int k) {
        return (soln(nums,k)-soln(nums,k-1));
    }

    public int soln(int[] nums, int k) {
      if(k<0) return 0;
      int l =0;
      int r =0;
      HashMap<Integer,Integer> mpp =  new HashMap<>();//nums[i], frequency
      int count =0;
      
      for(r=0;r<nums.length;r++){
        mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
        if(mpp.size()<=k){
            //
        }else{
            while(mpp.size()>k){
                   mpp.put(nums[l],mpp.getOrDefault(nums[l],0)-1);
                   if(mpp.getOrDefault(nums[l],0)==0) mpp.remove(nums[l]);
                   l++;
            }
        }
         count+= r-l+1;
      }
      return count;
    }

}