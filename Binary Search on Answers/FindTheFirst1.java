public class FindTheFirst1{
    public static void main(String[] args) {
        int[] nums= {0,0,1,1,1,1,1};
        System.out.println("    "+ bs(nums, nums.length));
    }
    public static int check(int[] nums,int n,int m){
        if(nums[m]==1) return 1;
        else return 0;
    }
    public static int bs(int[] nums,int n){
        int s=0;
        int e=n-1;
        int ans=-1;

        while (s<=e) {
            int m = s-(s-e)/2;

            if(check(nums,n,m)==1){
                ans=m;
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return ans;

    }
}