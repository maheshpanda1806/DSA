import java.util.*;
public class frogJump {
    //tabulation
    public static int tabulation(int n, int heights[]) {
  // If there are no stairs or only one stair, no energy is needed
  if (n == 0 || n == 1) return 0;

  // Initialize an array to store the minimum energy needed to reach each stair
  int[] dp = new int[n];
  
  // Iterate through the stairs, starting from the last one
  for (int i = n - 2; i >= 0; i--) {
      // Calculate the energy needed to jump from the current stair to the next stair
      int jump1 = dp[i + 1] + Math.abs(heights[i + 1] - heights[i]);
      
      // If there's a stair two steps ahead, calculate the energy needed for a two-stair jump
      int jump2 = (i < n - 2 ? dp[i + 2] + Math.abs(heights[i + 2] - heights[i]) : Integer.MAX_VALUE);
      
      // Store the minimum energy needed to reach the current stair
      dp[i] = Math.min(jump1, jump2);
  }

  // Return the minimum energy needed to reach the 0th stair
      return dp[0];
    }

    //memoization
    public static int frogJump(int n, int heights[]) {
        if (n == 0 || n == 1) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
         dp[0] = 0; // Initializing energy needed to reach the 1st stair

        return soln(n, 0, heights, dp,0);
    }



    public static int soln(int n, int idx, int heights[], int[] dp,int ans) {
        if (idx == n - 1) return ans;
        if (dp[idx] != -1) return dp[idx];

        int c = soln(n, idx + 1, heights, dp,ans+ Math.abs(heights[idx + 1] - heights[idx])) ;
        int d = Integer.MAX_VALUE;
        if (idx != n - 1) 
            d = soln(n, idx + 2, heights, dp,ans+ Math.abs(heights[idx + 2] - heights[idx])) ;

        dp[idx] = Math.min(c, d);
        return dp[idx];
    }
}

