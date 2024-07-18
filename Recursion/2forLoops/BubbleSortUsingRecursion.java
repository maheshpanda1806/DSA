import java.util.Arrays;

public class BubbleSortUsingRecursion {
    public static void main(String[] args) {
        int [] arr={89,31234,9,101};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
      sort(arr, 0, 1, arr.length-1);
 
    }
    public static void swap(int[] arr,int i,int j){
      int temp =arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    public static void sort(int []arr,int i,int j,int end){
        if (i>arr.length-2) {
            return;
        }
        if (j>end){
        sort(arr, i+1, 1, end-1);
        }else{
            if (arr[j-1]>arr[j]) {
                swap(arr, j-1, j);
            }
            sort(arr, i, j+1, end);
        }
    } 
}