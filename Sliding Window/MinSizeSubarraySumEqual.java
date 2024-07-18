public class MinSizeSubarraySumEqual {
    public static void main(String[] args) {
        // Example 1
        // int target1 = 7;
        // int[] nums1 = {2, 3, 1, 2, 4, 3};
        // System.out.println();
        // System.out.println(minSubArrayLen(target1, nums1)); // Output: 2
        
        // // Example 2
        // int target2 = 4;
        // int[] nums2 = {1, 4, 4};
        // System.out.println();
        // System.out.println(minSubArrayLen(target2, nums2)); // Output: 1
        
        // Example 3
        int target3 = 0;
        int[] nums3 = {1};
        System.out.println();
        System.out.println(ans(target3, nums3)); // Output: 0
    }
    //subarray With target equal to K//WONT WORK FOR NEGATIVES
    public static int ans(int target, int[] nums) {
        int l=0;
        int r=0;
        int sum =0;
        int count =0 ;
        for ( r = 0; r < nums.length; r++) {
            sum+=nums[r];
            //expand
            if (sum<=target) {
                if (sum==target) {
                    count++;
                }
            }else{//shrinking
               while (sum>target) {
                sum-=nums[l];
                sum-=nums[r];
                r--;
                l++;
               }
            }
        }
        return count;
    }

    public static int minSubArrayLen2(int target, int[] nums){
        int minLen=Integer.MAX_VALUE;
        int len=Integer.MAX_VALUE;
        int l=0;
        int r=0;
        int sum=0;

        for(r = 0;r<nums.length;r++){
         sum+=nums[r];
         //shrinking
         if (sum<target) {
            continue;
         }else{
            while (sum >= target) {
                minLen = Math.min(minLen, r - l + 1); // Update minLen if the current window is smaller
                sum -= nums[l]; // Subtract the leftmost element from the sum
                l++; // Move the left pointer to the right
            }
         }
        }
        return minLen;
    }
}
