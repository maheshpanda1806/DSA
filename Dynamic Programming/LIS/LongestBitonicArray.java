import java.util.Arrays;

public class LongestBitonicArray {
    static int[] dp;
    public static void main(String[] args) {
        int[] nums = {10,22,9,33,21,50,41,60,80,3};
        int n = nums.length;
        dp = new int[n];

        for(int i=0;i<n;i++){
            int max = -1;//index of max element from [0 to i-1] in dp arr such that the 
            //corresponding element is smaller than nums[i]
            for(int j =0;j<i;j++){
                if(max==-1 && nums[j]<nums[i]){
                    max = j;
                }
                else if(nums[j]<nums[i] && dp[j]>dp[max]){
                    max = j;
                }
            }
            if(max==-1) dp[i] =1;
            else{
                dp[i] = dp[max]+1;
            }
        }
        System.out.println(Arrays.toString(dp));

        int[] dp2 = new int[n];

        for(int i=n-1;i>=0;i--){
            int max = -1;//index of max element from [ i+1 to N-1] in dp arr such that the 
            //corresponding element is smaller than nums[i]
            for(int j =n-1;j>=i+1;j--){
                if(max==-1 && nums[j]<nums[i]){
                    max = j;
                }else if(nums[j]<nums[i] && dp2[j]>dp2[max]){
                    max = j;
                }
            }
            if(max==-1) dp2[i] = 1;
            else dp2[i] = dp2[max]+1;
        }
        int maxi = 0;
        for(int i =0;i<dp.length;i++){
           dp[i] = dp[i] + dp2[i] -1;
           if(dp[i]>dp[maxi]) maxi = i;
        }
        System.out.println(Arrays.toString(dp2));
        System.out.println(Arrays.toString(dp));
        System.out.println(maxi);
        System.out.println(dp[maxi]);
    }
}
