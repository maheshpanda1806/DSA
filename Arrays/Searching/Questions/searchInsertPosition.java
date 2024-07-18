public class searchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(target<nums[0]) return 0;
        if(target>nums[nums.length-1]) return nums.length;

        int s = 0;
        int e = nums.length -1;

        int mid;
        while(e>=s){
           mid = s - (s-e)/2;

            if(target<nums[mid]){
               e = mid -1;
            }
            else if(target == nums[mid]){
                return mid;
            }
            else{
                s = mid + 1;
            }
        }
       
        return e+1;
    }
}