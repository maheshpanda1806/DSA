public class MinimumOperationToReduceXtoZero {
    //Think in reverse; instead of finding the minimum prefix + suffix, find the maximum subarray.
    class Solution {
        public int minOperations(int[] arr, int x) {
            int sum = 0;
            for(int i : arr) sum+=i;
            int target =  sum-x;
    
            int l=0;
            int r=0;
            int n=arr.length;
            int sumi=0;
            int max = -1;
            while(r<n){
                sumi+=arr[r];
                while(sumi>target && l<=r){
                    sumi-=arr[l++];
                }
                if(sumi==target) max=Math.max(max,r-l+1);
                //shrink
                r++;
            }
            if(max==-1) return max;
            return n-max;
        }
    }
}
