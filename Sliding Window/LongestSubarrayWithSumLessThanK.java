
public class LongestSubarrayWithSumLessThanK {
public static void main(String[] args) {
    int [] arr = {2,5,1,6,10,2,2,2,2,2,2};
    int k = 14;
    longestSubarray2(arr, k);
} 
//prints both last subarray that's Satisfy the condition + length  // O(N+N) but if we want dont want to print the last subarray(lets say max Subarray) than use this checks all the possible subarrays
public static void longestSubarray(int []arr, int k) {
    int sum =0;
    int l =0;
    int r =0;
    int leftAns = 0;
    int rightAns = 0;
    int maxLen = 0;
    while (r<arr.length) {
        sum += arr[r];
        while(sum>k) {
            sum = sum -arr[l];
            l++;
        }
        if (sum<=k) {
            if (maxLen < r-l+1) {
                maxLen = r-l+1;
                leftAns = l;
                rightAns = r;
            }
        }
        r++;
    }
    System.out.println("       maxLEN     " + maxLen);
    System.out.println("       Right     " + leftAns);
    System.out.println("       Left     " + rightAns);

}

//prints both last subarray + length  // O(N) if we only want the length use this method as it doesnt shrink the array below maxLen as we only want maxLen,so of sum exceeds k then we shrink to it again to maxLen by shrinking it by only one time, check if sum still exceed if does dont do anything just move further for all possible ans at maxLen+1 and firther
public static void longestSubarray2(int []arr, int k) {
    int sum =0;
    int l =0;
    int r =0;
    int leftAns = 0;
    int rightAns = 0;
    int maxLen = 0;
    while (r<arr.length) {
        sum += arr[r];
        if(sum>k) {
            sum = sum -arr[l];
            l++;
        }
        if (sum<=k) {
            if (maxLen < r-l+1) {
                maxLen = r-l+1;
                leftAns = l;
                rightAns = r;
            }
        }
        r++;
    }
    System.out.println("       maxLEN     " + maxLen);
    System.out.println("       Right     " + leftAns);
    System.out.println("       Left     " + rightAns);
}
}