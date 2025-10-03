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
    public static int frog(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return rec(n-1, heights, dp, n-1);
    }

    public static int rec(int level, int heights[], int[] dp, int n) {
        if (level == 0)return dp[level]= 0;   //function to reach 0 from level

        // Memoization check
       if(dp[level]!=-1) return dp[level];

        int energy = Integer.MAX_VALUE;

        
            energy = Math.min(energy,rec(level-1,heights,dp,n) +
                Math.abs(heights[n-level]-heights[n-level+1]));
        

        if (level>1) {
            energy = Math.min(energy,rec(level-2,heights,dp,n) +
                Math.abs(heights[n-level]-heights[n-level+2]));
        }

        dp[level]=energy;
        return energy;
    }
}

