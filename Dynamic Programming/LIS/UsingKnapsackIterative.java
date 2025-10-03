import java.util.Arrays;

public class UsingKnapsackIterative {
    static int[][] dp;

    public static int ans(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n + 2; i++) {
            dp[n][i] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n + 1; j >= 0; j--) {
                if (j == n + 1 || arr[i] < arr[j - 1]) {
                    dp[i][j] = Math.max(1 + dp[i + 1][i + 1], dp[i + 1][j]);
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
     int[] nums = {10,9,2,5,3,7,101,18};
    dp = new int[nums.length + 1][nums.length + 2]; 
        for (int[] arr : dp) Arrays.fill(arr, 0);
        int ans =  ans(nums);
        System.out.println(ans);
   }
}
