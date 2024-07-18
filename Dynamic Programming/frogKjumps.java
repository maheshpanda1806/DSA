public class frogKjumps {
    public static int soln(int n, int k, int idx, int heights[], int[] dp, int ans) {
        if (idx == n - 1) return ans;
        if (dp[idx] != -1) return dp[idx];

        int temp = Integer.MAX_VALUE;

        // Loop through possible jump lengths
        for (int i = 1; i <= k; i++) {
            if (idx + i < n) { // Check if jump doesn't go beyond the last stair
                // Calculate energy for each jump and update the minimum
                int c = soln(n, k, idx + i, heights, dp, ans + Math.abs(heights[idx + i] - heights[idx]));
                temp = Math.min(c, temp);
            }
        }

        dp[idx] = temp;
        return dp[idx];
    }
}
