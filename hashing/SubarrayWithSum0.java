import java.util.*;
public class SubarrayWithSum0 {
    public static void main(String[] args) {
        int[] arr = {10,2,-2,-20,10};
        System.out.println(subarraywithsum0(arr));
    }

    public static int subarraywithsum0(int[] arr){
        int maxlen = 0;
        int sum = 0;
       // int count =0;
        HashMap<Integer,Integer> hs = new HashMap<>();
        // hs.put(0, -1);
       for (int j = 0; j < arr.length; j++) {
          sum+=arr[j];
          if(sum ==0)   maxlen = Math.max(maxlen, j +1);
        if(hs.containsKey(sum)){
              // count++;
               maxlen = Math.max(maxlen, j - hs.get(sum));
          } 
          if (!hs.containsKey(sum)) {
              hs.put(sum, j);
          }
       }
       //System.out.println("Count" + count);//CHECK NOTES WHY WONT THESE WORK; 
        return maxlen;
    }
}
