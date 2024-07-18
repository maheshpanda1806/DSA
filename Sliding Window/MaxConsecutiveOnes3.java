//leetcode-
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
    int [] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
    int k = 3;
    System.out.println("ASDFGHJKL    "+longestOnes(arr, k));
    }
    //This Question can be thought as Longest Subarray with atmost K zeroes
    public static int longestOnes(int[] nums, int k) {
       int maxlen =0;
       int l = 0;
       int r = 0;
       int zeroes = 0;
       int len = 0;
       for (r = 0; r < nums.length; r++) {
         if (nums[r]==0) {
            zeroes++;
            if (zeroes>k) {
                while (nums[l]==1) {
                    l++;
                }
                l++;
                zeroes--;
                continue;
            }
         }
            len = r-l+1;
            maxlen = Math.max(maxlen, len);
       }

       return maxlen; 
    }
}
