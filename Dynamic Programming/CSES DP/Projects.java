import java.util.*;

public class Projects {
    static final long MOD = 1000000007;
    static long dp[];
    
    public static long soln(int n,int[][] arr,int level){
         // function that returns the max amt of money
        // he can earn from level to N
        if(level>=n) return 0;
        
        if(dp[level]!=-1) return dp[level];
        int idx =  bs(arr,n,arr[level][1],level+1);  
        long pick =  arr[level][2];
        if(idx!=-1) pick += soln(n,arr,idx);

        long np = soln(n,arr,level+1);
        return dp[level]=Math.max(pick,np);
    }
    public static int bs(int[][] arr,int n,int target,int start){
      //returns the idx of first valuse that is strictly greater than target
      //else return -1;
      int s = start;
      int e = n-1;
      int ans = -1;
      while(s<=e){
        int m = s + (e-s)/2;
        
        if(arr[m][0]>target){
          ans = m;
          e = m-1;
        }else s = m+1;
      }
      return ans;
    }
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      int[][] arr = new int[n][3];
      
      for(int i = 0; i < n; i++) {
          arr[i][0] = sc.nextInt();
          arr[i][1] = sc.nextInt();
          arr[i][2] = sc.nextInt();
      }
      
      Arrays.sort(arr, (a,b) -> (a[0] - b[0]));
      long[] dp = new long[n+1];
      dp[n] = 0;
      
      for(int i = n-1; i >= 0; i--) {
          int nextIndex = bs(arr, n, arr[i][1],i+1);
          long pick = arr[i][2];
          if(nextIndex != -1) {
              pick = (pick + dp[nextIndex]) % MOD;
          }
          dp[i] = Math.max(pick, dp[i+1]) % MOD;
      }
      
      System.out.println(dp[0]);
      sc.close();
  }
}
