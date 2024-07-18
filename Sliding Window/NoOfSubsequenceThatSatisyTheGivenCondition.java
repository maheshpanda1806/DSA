class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int[] pow2 = new int[n];
        pow2[0] = 1;

        // Precompute powers of 2 modulo MOD
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        
        return count;
    }
}