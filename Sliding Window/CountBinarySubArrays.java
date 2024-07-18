public class CountBinarySubArrays {
    
    public int numberOfSubarrays(int[] nums, int k) {
        return (soln(nums,k)-soln(nums,k-1));
    }

    public int soln(int[] nums, int k) {
        int l =0;
        int r =0;
        int count=0;
        int sum = 0;   

        for(r =0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>k){
              sum-=nums[l];
              l++;
            }
            count+= r-l+1;
        }
        return count;

    }
}
