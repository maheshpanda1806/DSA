import java.util.Arrays;

public class MinimumCostForTickets {
    class Solution {
    int[][] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length+1][400];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return rec(days,costs,0,0);
    }
    public int rec(int[] days,int[] costs,int level,int cv){
        //function that returns the minimum cost from level to N-1 if 
        //cv days are already covered
        
        //base case
        if(level==days.length) return 0;
        
        if( dp[level][cv]!=-1) return dp[level][cv];

        int cost = (int)1e8; 
        if(cv>=days[level]){
          //have pass for this day no need to buy again
          cost = Math.min(rec(days,costs,level+1,cv),cost);
        }else{
            //buy New Pass
            //1 day pass
             cost =  Math.min(costs[0] +rec(days,costs,level+1,days[level]),cost);
             //7 day pass
             cost = Math.min(costs[1] +rec(days,costs,level+1,days[level]+6),cost);
             //30 day pass
             cost =  Math.min(costs[2]+rec(days,costs,level+1,days[level]+29),cost);
        }
        return dp[level][cv] = cost;
    }
 }
}
