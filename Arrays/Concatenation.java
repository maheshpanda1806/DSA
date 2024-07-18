public class Concatenation{
    public static void main(String[] args) {
        int [] nums ={-1,0,3,5,9,12};
        System.out.println(search(nums,9));
    }
    public static int search(int[] nums, int target) {
        return search1(nums, target,0,nums.length-1);
    }

    public static int search1(int[] nums, int target,int s,int e) {
        int m = s -(s-e)/2;

        if(s>e){
          return -1;
        }
        if(target==nums[m]){
          return m;
        }
        
            if(nums[m]<target){
                 return search1(nums, target, m+1, e);
            }
           else{
                 return search1(nums, target, s, m-1);
            }
        

        
    }

}