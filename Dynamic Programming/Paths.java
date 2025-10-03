import java.util.Arrays;

public class Paths{
    /*here is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.*/
  // Unique Path 1
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
           for(int[] arr : dp) Arrays.fill(arr,-1);
            return rec(m-1,n-1,dp);
        }
        public int rec(int r,int c,int[][] dp){
            //function that returns the  no of ways from r,c to 0,0
            //pruning
            if(r<0 || c<0) return 0;
    
            //base case
            if(r==0 && c==0) return dp[0][0] =1;
             
            if(dp[r][c]!=-1) return dp[r][c];
            int right = rec(r,c-1,dp);
            int down = rec(r-1,c,dp);
    
            return dp[r][c] = right + down;
        }
    }
    //unique paths 2 this one consist of obstacles
    class Solution2 {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] i : dp) Arrays.fill(i, -1);
        return rec(m-1,n-1,dp,grid);
    }

    public int rec(int r,int c,int[][] dp,int[][] grid){
        //function that returns the  no of ways from r,c to 0,0
        //pruning
        if(r<0 || c<0 || grid[r][c]==1) return 0;

        //base case
        if(r==0 && c==0) return dp[0][0] =1;
         
        if(dp[r][c]!=-1) return dp[r][c];
        int right = rec(r,c-1,dp,grid);
        int down = rec(r-1,c,dp,grid);

        return dp[r][c] = right + down;
    }
}
}