public class PeakOfMountainArr {
    public static void main(String[] args) {
        
    }
    public static int check(int[] nums,int n,int m){
        if(m==n-1) return 1;
        if(nums[m=1]<nums[m]) return 1;
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
