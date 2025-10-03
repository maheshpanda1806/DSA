import java.util.*;

public class MaxConsecutiveSum {
   public static void main(String[] args) {
    int [] arr = {1,-1,2,3,3,4,5,-1};
    int k = 4;
    maxConsecutiveSum(arr, k);
   }

   public static void maxConsecutiveSum(int [] nums, int k){
    int l =0;
    int r = k-1;
    int lowerIdx = l;
    int upperIdx = r;
    int sum =0;
    for (int i = 0; i <=r; i++) {
        sum +=nums[i];
    }
    int max = sum;
    while (r<nums.length-1) {
        sum = sum - nums[l];
        l++;r++;
        sum = sum + nums[r];
        if(sum>max){
            max = sum;
            lowerIdx = l;
            upperIdx = r;
        }
    }
    System.out.println("sum "+  max);
    System.out.println("lowerIndex "+  lowerIdx);
    System.out.println("Upper Index "+  upperIdx);

   }
}