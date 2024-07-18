import java.util.*;

public class TwoThreeFourSum {
    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        Map <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0]= i;
                result[i] = map.get(nums[i]);
            }
                map.put(nums[i], i);
            
        }
        return result;
    }
    
    public static int ascending(int [] arr, int target,int start){
      
        int s = start;
     
        int e =arr.length -1;
     

        while(e>= s){
            int mid = s - (s-e)/2;

            if(target>arr[mid]){
                s = mid +1;

            }
            else if(target<arr[mid]){
                e = mid -1;
            }
            else{
                //answer found 
                return mid;
            }
        }
        //answer not found
       return -1;
    }

     public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
       
       for (int i = 0; i < arr.length; i++) {
        for (int j = i+1; j < arr.length; j++) {
            int x = ascending(arr, -1*(arr[i]+arr[j]), j+1);
             List<Integer> curr = new ArrayList<>();
             if (x !=-1) {
              curr.add(i);
              curr.add(j);
              curr.add(x);
              ans.add(curr);
           }
        }
       }
       return ans;
    }

     public int[] findIntersectionValues(int[] nums1, int[] nums2) {
      
       Map <Integer,Integer> map1 = new HashMap<>();
       Map <Integer,Integer> map2 = new HashMap<>();

       for(int i =0;i<nums1.length;i++){
        for(int j = 0;j<nums2.length;j++){
           if(nums1[i]==nums2[j]){
               map1.put(nums1[i],map1.getOrDefault(nums1[i], 0)+1);
           }
        }
       }

       for(int i =0;i<nums1.length;i++){
        for(int j = 0;j<nums2.length;j++){
           if(nums1[i]==nums2[j]){
               map2.put(nums2[j],map2.getOrDefault(nums2[j], 0)+1);
           }
        }
       }

       int count1 = 0;
       int count2 = 0;
       
       for (int num : nums1) {
         if (map1.get(num)>0) {
            count1++;
         }
    }

    for (int num : nums2) {
         if (map2.get(num)>0) {
            count2++;
         }
    }

      return (new int[] {count1,count2});

    }
}
