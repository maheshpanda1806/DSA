import java.util.Arrays;

public class SubsetSumTarget {
    
class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        int[][] dp = new int[n][sum + 1];
        
        // Initialize dp array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return rec(0, sum, arr, dp) == 1;
    }

    public static int rec(int level, int target, int[] arr, int[][] dp) {
        //function checks if the target exist in level....N
       
        if (level == arr.length) return target==0? 1 : 0; 
        
        if (dp[level][target] != -1) {
            return dp[level][target];
        }

        int pick = 0;
        if (target >= arr[level]) {
            pick = rec(level + 1, target - arr[level], arr, dp); 
        }
        int notPick = rec(level + 1, target, arr, dp); 

        
        dp[level][target] = (pick == 1 || notPick == 1) ? 1 : 0;
        return dp[level][target];
    }
}
}
