public class SearchInRotatedArr {
   
    //unique Array
        public int search(int[] nums, int target) {
             int s = 0;
            int e = nums.length - 1;
            //int ans = -1;
    
            while(e>=s){
              int mid = s - (s-e)/2;
              if(nums[mid] == target) return mid;
              
              //left sorted
              if(nums[s]<=nums[mid]){
                  //is in the sored part
                 if(nums[s]<=target && target<=nums[mid]){
                     e = mid-1;
                 }//is not in the  sorted part
                 else{
                     s = mid+1;
                 }
              }
              //right sorted
              if(nums[mid]<nums[e]){
                  //is in the sored part
                 if(nums[mid]<=target && target<=nums[e]){
                     s = mid+1;
                 }//is not in the  sorted part
                 else{
                     e = mid-1;
                 }
              }
            }
    
            return -1;
        }
    
}
// when it have duplicates
class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;

        while(e>=s){
int mid = s + (e - s) / 2;      
   if(nums[mid]==target) return true;
         if(nums[s]==nums[mid] && nums[e]==nums[mid] ){
            s = s+1;
            e = e-1;
            continue;
         }

       
         //left sorted
         if(nums[s]<=nums[mid]){
          //is in sorted side
          if(nums[s]<=target && target<=nums[mid]){
              e = mid -1;
          }//is not in sorted side
          else{
              s = mid + 1;
          }
         }
         //right sorted
         else{
           //is in sorted side
          if(nums[mid]<=target && target<=nums[e]){
              s = mid+1;
          }//is not in sorted side
          else{
              e = mid - 1;
          }
         }
        }
        return false;
    }
}