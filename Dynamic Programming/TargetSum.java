import java.util.*;
public class TargetSum {
    int[][] dp;
    int offset;
    public int findTargetSumWays(int[] nums, int target) {
         
         offset=sum(nums);
         dp = new int[nums.length][2*offset+1];
         if (target > offset || target < -offset) return 0;

        for(int[] arr : dp) Arrays.fill(arr,-1);
        return rec(0,target,nums,0);
    }
    public int sum(int[] nums){
        int sum=0;
        for(int in : nums) sum= sum+in;
        return sum;
    }
    public int rec(int level,int target,int[] nums,int sum){
        //function that returns the number of soln from level to N

        //base case
        if(level==nums.length){
          if(sum==target) return 1;
          else return 0;
        }
        if(dp[level][sum+ offset]!=-1) return dp[level][sum+ offset];
        int add = rec(level+1,target,nums,sum+nums[level]);
        int sub = rec(level+1,target,nums,sum-nums[level]);

        return dp[level][sum+ offset]=add + sub;

    }
}