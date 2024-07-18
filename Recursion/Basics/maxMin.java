import java.util.*;
public class maxMin {
    public static void main(String[] args) {
        int []arr= {2,3,4,5,6,7,12,7,34,12};
        System.out.println(max(arr));
        System.out.println(min(arr));
       int [] ans = maxmin(arr);
       System.out.println(Arrays.toString(ans));
    }
    public static int[] maxmin(int [] arr){
        return new int[] {max(arr),min(arr)};
    }

    public static int max(int[] arr){
        return max(arr, 0, arr.length-1);
    }
    public static int min(int[] arr){
        return min(arr, 0, arr.length-1);
    }
    private static int max(int []arr, int i,int j){
     if(i>=j) return arr[i];

     int mid = i +(j-i)/2;
     int max1 = max(arr, i, mid);
     int max2 = max(arr, mid+1, j);
     return Math.max(max1, max2);
    }

    private static int min(int []arr, int i,int j){
        if(i>=j) return arr[i];
   
        int mid = i +(j-i)/2;
        int min1 = min(arr, i, mid);
        int min2 = min(arr, mid+1, j);
        return Math.min(min1, min2);
       }
}
