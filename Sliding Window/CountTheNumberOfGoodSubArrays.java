import java.util.*;
public class CountTheNumberOfGoodSubArrays {
//did it on my own fully
class Solution {
    public long countGood(int[] nums, int k) {
        long pairs = 0;
        HashMap<Integer, Long> mpp = new HashMap<>(); // number, frequency
        int r = 0;
        int l = 0;
        long count = 0;

        for (r = 0; r < nums.length; r++) {
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0L) + 1);
            if (mpp.get(nums[r]) > 1) {
                pairs += mpp.get(nums[r]) - 1;
            }
            if (pairs >= k) {
                // Shrink the window
                while (pairs >= k) {
                    count += nums.length - r;
                    mpp.put(nums[l], mpp.getOrDefault(nums[l], 0L) - 1);
                        pairs -= mpp.get(nums[l]);
                    l++;
                }
            }
        }
        return count;
    }
}

}
