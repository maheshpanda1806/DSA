public class PeakOfMountainArray {
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6,4,3,2};
       // System.out.println(search(arr));//
          //System.out.println(arr[search(arr)]);//6
    }
}
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        if(nums[n-2]<nums[n-1] ) return n-1;
        if(nums[0]>nums[1]) return 0;

        int s = 1;
        int e = nums.length-2;
        int mid;
        int ans = -1;
        while(e>=s){
                       mid=s+(e-s)/2;
            
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }

            if(nums[mid]<nums[mid+1]){
                s = mid+1;
            }
            else {
                e = mid-1;
            }

        }
        return ans;
    }

    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1;

        if(needle.length()>needle.length()) return -1;

        if (needle.length()==haystack.length()) {
            if(needle.contains(haystack)) return 0;
            else return -1;
        }

        int ans = -1;
        int j =-1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i)==needle.charAt(0)) {
                ans = i;
                j = i;
            }
        }

        if (ans!=-1) {
           for (int i = j; i < haystack.length(); i++) {
                if (haystack.charAt(i)!= needle.charAt(i=needle.length())) {
                    ans = -1;
                }
                if (i == needle.length()) break;
                
           }
        }
        return ans;
    }
}