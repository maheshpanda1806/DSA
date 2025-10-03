import java.util.Arrays;
public class NinjaTraining {
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
      int[][] dp = new int[n][4];//level,k
      for(int[] arr : dp) Arrays.fill(arr,-1);
      return rec(n-1,3,points,n-1,dp);
    }
   public static int rec(int level, int k, int[][] p, int n, int[][] dp) {
    // function to return max points scored
    // from level to 0 and last performed was k at level-1
    // base case
    if (level == 0) {
        int maxPoints = Integer.MIN_VALUE;
        for (int i = 0; i <= 2; i++) {
            if (i != k) {
                maxPoints = Math.max(maxPoints, p[n - level][i]);
            }
        }
        return dp[level][k] = maxPoints;
    }

    if (dp[level][k] != -1) return dp[level][k];

    int maxPoints = 0;
    for (int i = 0; i <= 2; i++) {
        if (i != k) {
            maxPoints = Math.max(maxPoints, p[n - level][i] + rec(level - 1, i, p, n, dp));
        }
    }
    dp[level][k] = maxPoints;
    return maxPoints;
}

}   
}
