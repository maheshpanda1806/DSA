import java.util.HashMap;

public class CountSubarrayWithSumK {
     public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int j =0;j<nums.length;j++){
            sum+=nums[j];
            if(sum==k) count++;
            int rem = sum-k;
            if(mpp.containsKey(rem)) count+=mpp.get(rem);
            mpp.put(sum,mpp.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}
