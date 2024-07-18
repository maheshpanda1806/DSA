class Solution {
    //tabulation M2
    public int fib(int n) {
         if(n<0) return -1;
        if(n==0 || n==1) return n;
      int curr=-1;
      int prev2=0;
      int prev1=1;
      for(int i=2;i<=n;i++){
        curr = prev1+prev2;
        prev2 = prev1;
        prev1 = curr;
      }
    return curr;
    }
    
    //memoization
    public int soln(int n,int[] dp){
        if(n<0) return -1;
        if(n==0 || n==1) return n;

        if(dp[n]!=-1) return dp[n];
        
       int c = soln(n-1,dp);
       int d = soln(n-2,dp);
       dp[n] = c+d;
       return dp[n];
    }
}