import java.util.*;
public class MakeSumDivisibleByP {
    class Solution {
        public int minSubarray(int[] nums, int p) {
            long sum = sum(nums);
            long target =  sum%p; // sum = p*x + target ke form mein hai agar aisa kuch remove
            // karna hai ki divisible by ho p*y + target ko remove karo i.e find a sub array with remaider target 
    
            if(target==0) return 0;
            HashMap<Long,Integer> mpp = new HashMap<>();//remainder-> rightmost index(coz we need smallest check hashing notes)
            int minLen = Integer.MAX_VALUE;
            long prefixSum = 0;
    
            for(int i=0;i<nums.length;i++){
                prefixSum = (prefixSum + nums[i]) % p;
                prefixSum = (prefixSum + p) % p;            
                long remainder = (prefixSum - target + p) % p;  // Calculate the needed remainder to make sum divisible by p
                
                if(target==prefixSum) minLen = Math.min(minLen, i+1);  
    
                if (mpp.containsKey(remainder)) {
                    minLen = Math.min(minLen, i - mpp.get(remainder));  
                }
                
                mpp.put(prefixSum, i);//update everytime to keep right most element
            }
            return minLen == Integer.MAX_VALUE || minLen == nums.length ? -1 : minLen;
        }
        public long sum(int[] nums){
            long sum =0;
            for(int i=0;i<nums.length;i++) sum+=nums[i];
            return sum;
        }
    }
}
