import java.util.*;


public class Main{
static final int MOD = 1000000007;
     static int[] dp;
    // public static int ans(int n,int x,int[] arr){
    //     //function that returns  the no of ways
    //     //to form i from elements of arr
    //     //dp[i] = the minimum no of coins required 
    //     //to form i from elements of arr

    //     if(x==0) return 1;
       
    //     int ans = 0;
    //     for(int i : arr){
    //         if(x-i>=0) ans = ans +  ans(n, x-i, arr);
    //     }
    //     return ans;
    // }
    public static int iterative(int n,int x,int[] arr){
        dp = new int[x+1];
        Arrays.fill(dp,0);
        //dp[i] = the no of ways
        //to form i from elements of arr
        dp[0] = 1;
        
        for(int i = 1;i<dp.length;i++){
              for(int val : arr){
                if(i-val>=0){
                    dp[i] =(dp[i]+dp[i-val])%MOD;
                } 
              }
        }

        return dp[x];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int x = sc.nextInt(); 
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt(); 
        }
        //  dp = new int[x+1];
        //   Arrays.fill(dp,-1);

         int ans = iterative(n, x, coins);
         //if(ans>=1000000000) ans = -1;
        System.out.println(ans);
       // System.out.println();
        sc.close();
    }
}