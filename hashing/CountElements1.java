import java.util.*;

public class CountElements1{
    public static void main(String [] args){
      
        int[] array = {1, 2, 3, 4, 2, 2, 3, 1, 4, 5};
        int k = 2;

        int result = count1(k, array);
        System.out.println("Number of occurrences of " + k + ": " + result);

      System.out.println(countChar1('h', "Mahhhhhhesh"));
    }
    public static int count(int k,int [] arr){
      int [] hashArr = new int[12];
      for (int i = 0; i < arr.length; i++) {
        hashArr[arr[i]]+=1;
      }
      return hashArr[k];
    }
    public static int countChar(char a, String str){
         int [] hashArr = new int[26];
         str = str.toLowerCase();
         for (int i = 0; i < str.length(); i++) {
           hashArr[str.charAt(i) - 97]+=1;
         }

         return hashArr[a- 97];
    }
    public static int count1(int k,int [] arr){
       Map <Integer,Integer> mpp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
           mpp.put(arr[i], mpp.getOrDefault(arr[i], 0)+1);
         }
        
        return mpp.getOrDefault(k, 0);
    }
    
     public static int countChar1(char a, String str){
        Map <Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i), 0)+1);
        }
         return map.getOrDefault(a, 0);
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        Map <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0]= i;
                result[i] = map.get(nums[i]);
            }else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
}