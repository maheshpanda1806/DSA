public class RotatedArr {
    public static void main(String[] args) {
        
    }
    public static int check(int[] nums,int n,int m,int x){
        if(nums[m]<nums[0]) return 1;
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
