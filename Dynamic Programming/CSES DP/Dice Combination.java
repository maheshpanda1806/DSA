import java.util.*;

public class Main{
static final int MOD = 1000000007;
    public static int ans(int n){
      //function that returns the no.of ways to get n from dice
      //dp[i] = no.of ways to get i from dice

      int[] dp =  new int[n+1];
      Arrays.fill(dp,0);
      dp[0] = 1;
      for(int i =1;i<=n;i++){
        for(int j=1;j<=6;j++){
           if(i-j>=0) dp[i] = (dp[i] + dp[i - j]) % MOD;
        }
      }
      return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        System.out.println(ans(n)); 
    }
}