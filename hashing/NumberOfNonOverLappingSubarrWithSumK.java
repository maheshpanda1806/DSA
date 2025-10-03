import java.util.*;
public class NumberOfNonOverLappingSubarrWithSumK {
    public int maxNonOverlapping(int[] nums, int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();//sum,index
        int count = 0;
        int prevIdx = -1;
        int sum =0;
        for(int i =0;i<nums.length;i++){
           sum = sum + nums[i];
           if(sum==k && prevIdx<0){
             count++;
             prevIdx =i;
             }
           int rem =  sum-k;
           if(mpp.containsKey(rem) && prevIdx< mpp.get(rem)+1){
             count++;
             prevIdx =i;
             }
           mpp.put(sum,i);
        }
        return count;
    }
}