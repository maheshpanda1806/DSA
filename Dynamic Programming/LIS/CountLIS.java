import java.util.*;

public class CountLIS {
    static int[] dp;

    public static void main(String[] args) {
        int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 3 };
        int n = nums.length;
        dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(count, 1); // Initialize count array to 1

        int maxi = 0; // index of overall maximum
        for (int i = 0; i < n; i++) {
            int max = -1; // index of max element from [0 to i-1] in dp array
            // such that the corresponding element is smaller than nums[i]
            for (int j = 0; j < i; j++) {
                if (max == -1) {
                    if (nums[i] > nums[j])
                        max = j;
                } else {
                    if (nums[i] > nums[j] && dp[j] > dp[max])
                        max = j;
                }

                // Update the count array for multiple LIS paths
                if (nums[i] > nums[j] && dp[j] + 1 == dp[i]) {
                    count[i] += count[j];
                }
            }
            if (max != -1) {
                dp[i] = 1 + dp[max];
            } else {
                dp[i] = 1;
            }

            if (max != -1 && dp[i] == dp[max] + 1) {
                count[i] = count[max];
            }

            if (dp[i] > dp[maxi])
                maxi = i;
        }

        int maxLength = dp[maxi];
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                totalCount += count[i];
            }
        }
        
        System.out.println("Length of LIS: " + maxLength);
        System.out.println("Number of LIS: " + totalCount);
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
    }
}
