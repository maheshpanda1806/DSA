import java.util.*;


public class Main{
static final int MOD = 1000000007;
     static int[][] dp;
     public static int iterative(int n,char[][] grid){
        //dp[i][j] = no of ways from i,j to n-1,n-1
        dp = new int[n][n];
        dp[n-1][n-1] = grid[n-1][n-1]== '*'? 0 : 1;

        for(int i = n-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(i==n-1 && j==n-1) continue;
                if(grid[i][j]=='*') dp[i][j] = 0;
                else dp[i][j] = (get(i+1,j,grid,dp,n) + get(i,j+1,grid,dp,n))%MOD;
            }
        }
        
        return dp[0][0];
     }
     public static int get(int i,int j,char[][] grid,int[][] dp,int n){
          
           if(i>=n || j>=n || grid[i][j]=='*') return 0;
           else return dp[i][j];
     }
   
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        int ans = iterative(n, grid);
        System.out.println(ans);
        sc.close();
    }
}