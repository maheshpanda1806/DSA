public class trobonacci {
    
}
class Solution {
    //memoization
    public int tribonacci(int n) {
        if(n<0) return -1;
        if(n==0 || n==1) return n;
        if(n==2) return 1;
        int prev3 = 0;
        int prev2 = 1;
        int prev1 = 1;
        int curr =-1;
        for(int i = 3;i<=n;i++){
        curr = prev3+prev2+prev1;
        prev3 = prev2;
        prev2 = prev1;
        prev1 = curr;
        }
        return curr;
    }

    public int soln(int n,int[] dp){
        if(n<0) return -1;
        if(n==0 || n==1) return n;
        if(n==2) return 1;
        if(dp[n]!=-1) return dp[n];

        int c = soln(n-1,dp);
        int d = soln(n-2,dp);
        int e = soln(n-3,dp);
        dp[n] = c+d+e;
        return dp[n];
    }

}