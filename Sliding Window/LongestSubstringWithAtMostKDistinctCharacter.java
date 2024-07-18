import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacter {
    public static void main(String[] args) {
        String st = "asacabasbd";
        int k = 3;
        System.out.println();
        System.out.println("THe logest "+totalFruit(st, k));
    }
    
      public static int totalFruit(String nums,int k) {
        //int typecount = 0;
        int l = 0;
        int r = 0;
        int len = 0;
        int maxLen = 0;

        HashMap<Character,Integer> mpp = new HashMap<>();
    // int[] nums = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        for ( r = 0; r < nums.length(); r++) {
           if(mpp.size()<=k){
              mpp.put(nums.charAt(r),mpp.getOrDefault(nums.charAt(r),0) + 1);
           }
           if(mpp.size()>k){
              while(mpp.size()>k){
                 mpp.put(nums.charAt(l),mpp.getOrDefault(nums.charAt(l),0)-1);
                 if(mpp.getOrDefault(nums.charAt(l),0)==0) mpp.remove(nums.charAt(l));
                 l++;
              }
           }
           len = r - l +1;
           maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }
   
    public class fruitsBasket {
      public static void main(String[] args) {
          int [] arr = {1,2,3,2,2};
          System.out.println();
          System.out.println(" " + totalFruit(arr));
      }
      //Longest Subarray with only 2(k) types of fruits 
      public static int totalFruit(int[] nums) {
          //int typecount = 0;
          int l = 0;
          int r = 0;
          int len = 0;
          int maxLen = 0;
    
          HashMap<Integer,Integer> mpp = new HashMap<>();
      // int[] nums = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
    
          for ( r = 0; r < nums.length; r++) {
             if(mpp.size()<=2){
                mpp.put(nums[r],mpp.getOrDefault(nums[r],0) + 1);
             }
             if(mpp.size()>2){
                while(mpp.size()>2){
                   mpp.put(nums[l],mpp.getOrDefault(nums[l],0)-1);
                   if(mpp.getOrDefault(nums[l],0)==0) mpp.remove(nums[l]);
                   l++;
                }
             }
             len = r - l +1;
             maxLen = Math.max(len,maxLen);
          }
          return maxLen;
      }
   }
}


