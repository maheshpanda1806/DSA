import java.util.Arrays;
import java.util.Stack;

public class LeetCodeNG1 {
    public static void main(String[] args) {
    int[] nums1 ={2,4};
    int[] nums2 ={1,2,3,4};
    System.out.println(getIndex(2, nums2));
   System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int [] ans = new int[nums1.length];
    for (int i = 0; i < ans.length; i++) {
        ans[i]=-1;
    }
    for (int i = 0; i < nums1.length; i++) {
    int start = getIndex(nums1[i], nums2);
    
    for (int j = start+1; j < nums2.length; j++) {
     if(nums1[i]<nums2[j]){
        ans[i]= nums2[j];
        break;
     }
    }
    }
    return ans;
    }

    public static int getIndex(int x,int [] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==x) {
                return i;
            }
        }
     return -1;
    }
}
