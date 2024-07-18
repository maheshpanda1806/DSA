// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

// Return the number of nice sub-arrays.
// Example 1:

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
// Example 2:

// Input: nums = [2,4,6], k = 1
// Output: 0
// Explanation: There are no odd numbers in the array.
// Example 3:

// Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
// Output: 16
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return (soln(nums,k)-soln(nums,k-1));
    }

    public int soln(int[] nums, int k) {
        if(k<0) return 0;
        int l=0,r=0,count=0,oddcount=0;
        
        for(r=0;r<nums.length;r++){
            if(nums[r]%2==0) nums[r]=0;
            else nums[r]=1;
            if(nums[r]==1) oddcount++;
            if(oddcount>k){
               while(oddcount>k){
                if(nums[l]==1) oddcount--;
                l++;
               }
            }
            count+= r-l+1;
        }
  return count;

    }
}