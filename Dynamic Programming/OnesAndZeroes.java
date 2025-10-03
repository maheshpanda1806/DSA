import java.util.Arrays;

public class OnesAndZeroes {
    class Solution {
    int[][][] dp;
    public int findMaxForm(String[] arr, int m, int n) {
        dp = new int[m+1][n+1][arr.length+1];
            for (int i = 0; i < m+1; i++) {
        for (int j = 0; j < n+1; j++) {
            Arrays.fill(dp[i][j], -1);
        }
    }
        return rec(arr,m,n,0);
    }
    public int rec(String[] arr,int m ,int n,int level){
        //function that returns the max length of required from Level to N

        //base case
        if(level==arr.length) return 0;
        
        if(dp[m][n][level]!=-1) return dp[m][n][level];
         int one = 0;
         int zero = 0;
        for(int i =0;i<arr[level].length();i++){
           if(arr[level].charAt(i)=='0') zero++;
           else one++;
        }
        int pick =0;
        if(m>=zero && n>=one) pick = 1 + rec(arr,m-zero,n-one,level+1); 
        int np = rec(arr,m,n,level+1);

        return dp[m][n][level]= Math.max(pick,np);
    }
}
}
