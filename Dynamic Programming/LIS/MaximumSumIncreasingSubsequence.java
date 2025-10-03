import java.util.Arrays;
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,22,9,33,21,50,41,60,80,3};
        int n = nums.length;
        int[] dp = new int[n];//dp[i] = max sum of increasing subseqeunce till 0 to i ending at i
        
        for (int i = 0; i < dp.length; i++){
            int max = -1;
            for (int j = 0; j < i; j++) {
                if(max==-1 && nums[j]<nums[i]){
                    max = j;
                }else if(nums[j]<nums[i] && dp[j]>dp[max]){
                    max = j;
                }   
            }
            if(max==-1) dp[i] = nums[i];
            else dp[i] = nums[i] + dp[max];
        }
        System.out.println(Arrays.toString(dp));
    }
}
