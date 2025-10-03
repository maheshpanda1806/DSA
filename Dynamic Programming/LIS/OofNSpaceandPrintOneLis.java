import java.util.*;
public class OofNSpaceandPrintOneLis {
    static int[] dp;
    public static void main(String[] args) {
        int[] nums = {10,22,9,33,21,50,41,60,80,3};
        int n = nums.length;
        dp = new int[n];
        int[] hash = new int[n];
        
        for(int i =0;i<n;i++){
            hash[i] = i;
        }

        //dp[i] = lis from 0 to i *that ends at i*
        int maxi =0; //index of overall maximum
        for (int i = 0; i < n; i++) {
            int max = -1;//index of max element from [0 to i-1] in dp arr such that the 
            //corresponding element is smaller than nums[i]
            for (int j = 0; j < i; j++) {
                if(max==-1){
                    if(nums[i]>nums[j]) max = j;
                }
                else {
                    if(nums[i]>nums[j] && dp[j]>dp[max]) max = j;
                }
            }
             if(max!=-1){
                dp[i] = 1 + dp[max];
                hash[i] = max; 
            }
             else dp[i] = 1;
             
            if(dp[i]>dp[maxi]) maxi = i;
        }
        List<Integer> ans = new ArrayList<>();

        int idx = maxi;

        while(idx!=hash[idx]){
            ans.add(nums[idx]);
            idx = hash[idx];
        }

        ans.add(nums[idx]);
        
        Collections.reverse(ans);
        System.out.println(ans);
        System.out.println(dp[maxi]);
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(hash));
    }
}
