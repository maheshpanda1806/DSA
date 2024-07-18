class FaLoccurence {
  public static void main(String[] args){
    // int [] ans = searchRange()
  }
  public int[] searchRange(int[] nums, int target) {
      int [] ans = new int[2];
      ans[0] = firstOccurence(nums,target);
      ans[1] = lastOccurence(nums,target);
      
      return ans;
  }
  public int firstOccurence(int[] num, int target ){
      int ans = -1;
      int low = 0;

      int len = num.length;

      int high = len-1;
      int mid;
      while(high>=low){
          mid = low - (low -high)/2;

          if(target < num[mid]){
            
              high = mid-1;
          }else if(target == num[mid]){
            //got the answer but the first occurence(more accurate) can be on left side so search there too
              ans = mid;
              high = mid-1;
          }
          else{
              low = mid+1;
          }
      }

     return ans;
  }

   public int lastOccurence(int[] num, int target ){
      int ans = -1;
      int low = 0;

      int len = num.length;

      int high = len-1;
      int mid;
      while(high>=low){
          mid = low - (low -high)/2;

          if(target < num[mid]){
              high = mid-1;
          }
          else if(target == num[mid]){
             //got the answer but the last occurence(more accurate) can be on right side so search there too
              ans = mid;
              low = mid+1;
          }
          else{
            
              low = mid+1;
          }
      }
     return ans;
  }
}