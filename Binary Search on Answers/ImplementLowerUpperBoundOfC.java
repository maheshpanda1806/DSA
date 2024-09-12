public class ImplementLowerUpperBoundOfC {
    public static void main(String[] args) {
        int[] nums= {1,5,10,31,33,33,35,100};
        System.out.println("    "+ bs(nums, nums.length,32));
    }
    public static int check(int[] nums,int n,int m,int x){
        if(nums[m]>=x) return 1; //lower bound
        else return 0;
    }
    public static int bs(int[] nums,int n,int x){
        int s=0;
        int e=n-1;
        int ans=n;

        while (s<=e) {
            int m = s-(s-e)/2;

            if(check(nums,n,m,x)==1){
                ans=m;
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return ans;

    }
}
