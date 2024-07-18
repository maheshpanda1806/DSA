public class minInRotatedArr {
    
}
class Solution {
    public int findMin(int[] arr) {
     int s = 0;
     int e = arr.length - 1;
     int ans = Integer.MAX_VALUE;
     while(e>=s){
         int mid = s +(e-s)/2;
         //eliminate the left half but save the 
         if(arr[s]<=arr[mid]){
             ans = Math.min(ans,arr[s]);
             s = mid+1;
         }else{
               e = mid -1;
             ans = Math.min(ans,arr[mid]);
            
         }
     }
     return ans;
    }
}