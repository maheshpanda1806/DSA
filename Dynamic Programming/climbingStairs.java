import java.util.*;
public class climbingStairs {
    //memoization
    static class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp,-1);

            //tabulation
            dp[0] = 1;

            for(int i =1;i<=n;i++){
                if(i>1) dp[i] = dp[i-1] + dp[i-2];
                else dp[i] = dp[i-1];
            }

            return dp[n];
        }
        public int rec(int level,int[] dp ){//function to reach 0 from level
           //base case
           if(level==0) return dp[level]= 1;
           
           if(dp[level]!=-1) return dp[level];
           int steps=0;
           steps+=rec(level-1,dp);
    
           if(level>1) steps += rec(level-2,dp);
    
           return dp[level]=steps;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        Solution solution = new Solution();
        int ans = solution.climbStairs(n);

        System.out.println(ans);
    }
}

/*You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step*/
// IS THE SAME AS FIBONACCI NUMBER
  
