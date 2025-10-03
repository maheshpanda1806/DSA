import java.util.*;

public class KQueriesSumFromLToR{
    public static void main(String[] args) {
    int[] arr = {4,3,2,1,-5,6};
     System.out.println(Arrays.toString(prefixSum(arr)));
    }
    public static int[] prefixSum(int[] arr){
      int[] prefix = new int[arr.length];//an array p[i] = a[0] + a[1] + to a[i];
      
      prefix[0] = arr[0];
      for(int i=1;i<arr.length;i++){
        prefix[i] = arr[i] + prefix[i-1];
      }
      return prefix;
    }  
}