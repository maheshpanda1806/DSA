class HouseRobber4 {
    public int minCapability(int[] nums, int k) {
       int s = 0;
       int e = -1;
       for(int i : nums) if(i>e) e = i;
       int ans = -1;

       while(s<=e){
        int m =  s+(e-s)/2;
        if(check(nums,k,m)){
            ans = m;
            e=m-1;
        }else s=m+1;
       }
      return ans;
    }
    public boolean check(int[] nums, int k, int max){
        //function that checks if we can rob >= k houses with capability <=max
        for(int i =0;i<nums.length;i++){
            if(nums[i]<=max){
                k--;
                if(k==0) return true;
                i++;
            }
        }
        return false;
    }
}