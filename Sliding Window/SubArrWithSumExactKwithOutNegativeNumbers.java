import java.util.*;
public class SubArrWithSumExactKwithOutNegativeNumbers {
    
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int l = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int r =0;
        int sum = 0;
        for(r=0;r<arr.length;r++){
            sum = sum+arr[r];
            while(sum>target){
                sum = sum -arr[l++];
            }
            
            if(sum==target){
                ans.add(l+1);
                ans.add(r+1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }
}
}