import java.util.*;
class Solution{
    public static int lenOfLongSubarr (int A[], int N, int K) {
        return soln(A,K);
        
    }
    
    public static int soln(int[] arr, int k) {
        int maxlen = 0;
        int sum = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if(sum ==k)   maxlen = Math.max(maxlen, j +1);
            if (hs.containsKey(sum - k)) {
                //count++;
                maxlen = Math.max(maxlen, j - hs.get(sum - k));
            }
            
           
            if (!hs.containsKey(sum)) {
                hs.put(sum, j);
            }
        }
            // System.out.println("Count" + count); count wont work gere coz we are not check each subarray we may miss some of the subararys in the process//CHECK NOTES
        return maxlen;
    }
     //subarray With target equal to K//WONT WORK FOR NEGATIVES 2pointers and sliding window approach
     public static int ans(int target, int[] nums) {
        int l=0;
        int r=0;
        int sum =0;
        int count =0 ;
        for ( r = 0; r < nums.length; r++) {
            sum+=nums[r];
            //expand
            if (sum<=target) {
                if (sum==target) {
                    count++;
                }
            }else{//shrinking
               while (sum>target) {
                sum-=nums[l];
                sum-=nums[r];
                r--;
                l++;
               }
            }
        }
        return count;
    }
}


