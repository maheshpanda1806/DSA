import java.util.*;

public class CountSubarraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            int rem = sum % k;
             if(sum%k==0) count++;
            // Adjust the remainder to always be positive
            if (rem < 0) {
                rem += k;
            }
            if (mpp.containsKey(rem)) {
                count += mpp.get(rem);
            }
            mpp.put(rem, mpp.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}


