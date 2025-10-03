import java.util.Arrays;
import java.util.List;

public class MinMaxPath {
    //min path from 00, m-1 ,n-1
    class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] i : dp) Arrays.fill(i, -1);
        return rec(m-1,n-1,dp,grid);
    }
    public int rec(int r,int c,int[][] dp,int[][] grid){
        //function that returns the  min path sum from r,c to 0,0
        //pruning
        if(r<0 || c<0) return Integer.MAX_VALUE;

        //base case
        if(r==0 && c==0) return dp[0][0]=grid[r][c];
         
        if(dp[r][c]!=-1) return dp[r][c];
        int right = rec(r,c-1,dp,grid);
        int down = rec(r-1,c,dp,grid);

        return dp[r][c] = Math.min(right,down) + grid[r][c];
    }
}
//triangle
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return rec(0,0,triangle,dp);
    }
    public int rec(int r,int c,List<List<Integer>> triangle,int[][] dp){
        //function to return the minimum path from r, c to end
        
        //pruning case
        if(r>=triangle.size() || c>=triangle.get(r).size()) return 0;
        //base case
        if(r==triangle.size()-1){
            return dp[r][c] = triangle.get(r).get(c);
        }
        if(dp[r][c]!=-1) return dp[r][c];
        int same = rec(r+1,c,triangle,dp);
        int right = rec(r+1,c+1,triangle,dp);
         
        return dp[r][c] =  Math.min(same,right) + triangle.get(r).get(c);
    }
}
//minimum falling paths
class Solution3 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp) Arrays.fill(arr, Integer.MAX_VALUE);
        
        int minResult = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minResult = Math.min(minResult, rec(0, j, matrix, dp));
        }
        return minResult;
    }
    
    private int rec(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;
        
        if (j < 0 || j >= n) return Integer.MAX_VALUE;
        if (i == n) return 0;
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        
        int down = rec(i+1, j, matrix, dp);
        int leftDiag = rec(i+1, j-1, matrix, dp);
        int rightDiag = rec(i+1, j+1, matrix, dp);
        
        dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
        return dp[i][j];
    }
}
}
