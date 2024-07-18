public class maxSumwithoutAdjacentElement {
 public static void main(String[] args){

 }
 public static int soln(int[] dp, int n, int[] arr, int idx, int sum) {
    if (n == 1) return arr[0];
    if (idx >= n) return 0; // Base case: out of bounds
    if (dp[idx] != -1) return dp[idx];

    int pick = soln(dp, n, arr, idx + 2, sum + arr[idx]);
    int notpick = soln(dp, n, arr, idx + 1, sum);
    dp[idx] = Math.max(pick, notpick);
    return dp[idx];
}
 
public static int solnTabulation(int[] dp, int n, int[] arr, int idx, int sum){
    if (n == 1) return arr[0];
    if (idx >= n) return sum; // Base case: out of bounds
   // if (dp[idx] != -1) return dp[idx];
   dp[n-1] = arr[n-1];

  for (int i = n-2; i >0; i--) {
    int notpick = dp[idx+1];
    int pick = arr[idx];
    if(idx!=n-2) pick+=dp[i+2];
    dp[idx]=Math.max(notpick, pick);
  }
  return dp[0];

}
}
