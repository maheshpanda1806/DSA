import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDivisibleSubset {
    public static void main(String[] args) {
        
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp =  new int[n];
        int[] hash = new int[n];
        for(int i=0;i<n;i++) hash[i] = i;
        int maxi =0;
        for(int i =0;i<n;i++){
            int max = -1;
          
            for (int j = 0; j <i; j++) {
                if(max==-1 && nums[i]%nums[j]==0){
                    max = j;
                }else if(nums[i]%nums[j]==0 && dp[j]>dp[max]){
                    max = j;
                }
            }
            if(max==-1) dp[i] = 1;
            else{
                 dp[i] = dp[max] + 1;
                 hash[i] = max;
            }
             if(dp[i]>dp[maxi]) maxi = i;
        }
        
        int idx = maxi;

        while(idx!=hash[idx]){
            ans.add(nums[idx]);
            idx = hash[idx];
        } ans.add(nums[idx]);

        //System.out.println(Arrays.toString(dp));
        return ans;
    }

}
