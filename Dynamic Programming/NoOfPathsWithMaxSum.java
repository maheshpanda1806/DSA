import java.util.Arrays;
import java.util.List;

public class NoOfPathsWithMaxSum {
    class Solution {
    int[][] dp;
    int[][][] dp2;
    final int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        int[] ans = new int[2];
        int m = board.size();
        int n = board.get(0).length();
        dp = new int[m][n];
        for(int[] arr : dp) Arrays.fill(arr,-2);
         ans[0] =  rec1(board,board.size()-1,board.get(0).length()-1);
        ans[0] = ans[0]==-1? 0: ans[0];
        

         dp2 = new int[m][n][ans[0]+1];
       for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            Arrays.fill(dp2[i][j], -2);
        }
    }
       
        ans[1] = rec2(board,board.size()-1,board.get(0).length()-1,ans[0]);
        return ans;
    }

    public int rec2(List<String> grid,int r,int c,int target){
     //function that return the number of paths from r , c to 0,0 with sum ==target
     //base case
        if(grid.get(r).charAt(c)=='E'){
            return target==0? 1 : 0;
        }


        if(dp2[r][c][target]!=-2) return dp2[r][c][target];

        int paths = 0;
        
        char ch = grid.get(r).charAt(c);
        int that = ch=='S'? 0 : ch-'0';


        if(check(r-1,c,grid) && target>=that){
            paths = (paths +  rec2(grid,r-1,c,target-that))%MOD;
        }
        if(check(r,c-1,grid) && target>=that){
            paths = (paths +  rec2(grid,r,c-1,target-that))%MOD;
        }
        if(check(r-1,c-1,grid) && target>=that){
            paths = (paths +  rec2(grid,r-1,c-1,target-that))%MOD;
        }
         
        return dp2[r][c][target] = paths;
    }


    public int rec1(List<String> grid,int r,int c){
        //function that returns max score from r,c to 0,0
        //base return 
        if(grid.get(r).charAt(c)=='E'){
            return 0;
        }

        if(dp[r][c]!=-2) return dp[r][c];

        int max =-1;

        if(check(r-1,c,grid)){
            max =  Math.max(max,rec1(grid,r-1,c));
        }
        if(check(r,c-1,grid)){
            max =  Math.max(max,rec1(grid,r,c-1));
        }
        if(check(r-1,c-1,grid)){
            max =  Math.max(max,rec1(grid,r-1,c-1));
        }
        if(max==-1) return dp[r][c] = -1;
        char ch = grid.get(r).charAt(c);
        int that = ch=='S'? 0 : ch-'0';
        
        return dp[r][c] = that + max;

    }
    public boolean check(int r,int c,List<String> grid){
        if(r<0 || c<0 || grid.get(r).charAt(c)=='X') return false;
        return true;
    }
}
}
