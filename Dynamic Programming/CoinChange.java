import java.util.Arrays;

public class CoinChange {
    class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[][] dp = new int[coins.length][amount+1];
        for(int[] i : dp)  Arrays.fill(i,-1);
        int ans = rec(0,amount,coins,dp);
        return ans==(int)1e8? -1:ans-1;
    }
    public int rec(int level,int target,int[] arr,int[][] dp){
        if(target<0) return (int)1e8;
        //if(target==0) return 1;
        if (level == arr.length) return target==0? 1 : (int)1e8; 
        if(dp[level][target]!=-1) return dp[level][target];
        int pick = 1 + rec(level,target-arr[level],arr,dp);
        int np = rec(level+1,target,arr,dp);
        
        return  dp[level][target] = Math.min(pick,np);
    }
}
}
