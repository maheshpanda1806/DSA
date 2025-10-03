import java.util.*;


public class Main{
static final int MOD = 1000000007;
    static int[] dp;
    // public static int ans(int n,int x,int[] arr){
    //     //function that returns the minimum no of coins required 
    //     //to form x from elements of arr
    //     //dp[i] = the minimum no of coins required 
    //     //to form i from elements of arr
    //     dp[0] = 0;
    //     if(dp[x]!=-1) return dp[x];
    //     int ans = (int)1e9;
    //     for(int i : arr){
    //         if(x-i>=0) ans = Math.min(ans, ans(n, x-i, arr));
    //     }
    //     return dp[x] =  1 + ans;
    // }
    public static int iterative(int n,int x,int[] arr){
        dp = new int[x+1];
        Arrays.fill(dp,(int)1e9);
        //dp[i] = the minimum no of coins required 
        //to form i from elements of arr
        dp[0] = 0;
        
        for(int i = 1;i<dp.length;i++){
              for(int val : arr){
                if(i-val>=0){
                    dp[i] = Math.min(dp[i],dp[i-val]);
                } 
              }
              dp[i]++;
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
         if(ans>=1000000000) ans = -1;
        System.out.println(ans);
       // System.out.println();
        sc.close();
    }
}