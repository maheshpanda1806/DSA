import java.util.Arrays;

public class UsingKnapsack {
   static int[][] dp;
public static int rec(int level,int[] arr,int lpi){
    //function that the lis from level to N-1 given that lpi is the last picked index
    if(level==arr.length) return dp[level][lpi+1]=0;
    

    if(dp[level][lpi+1]!=-1) return dp[level][lpi+1];

    if(lpi==-1 || arr[lpi]<arr[level]){
        int pick = 1 + rec(level+1,arr,level);
        int np =  rec(level+1,arr,lpi);
        return dp[level][lpi+1]= Math.max(pick,np);
    }else{
        return dp[level][lpi+1] = rec(level+1,arr,lpi);
    }
}
   public static void main(String[] args) {
    int[] nums = {10,9,2,5,3,7,101,18};
    dp = new int[nums.length + 1][nums.length + 2]; 
        for (int[] arr : dp) Arrays.fill(arr, -1);
        int ans =  rec(0, nums, -1);
        System.out.println(ans);
   }
}