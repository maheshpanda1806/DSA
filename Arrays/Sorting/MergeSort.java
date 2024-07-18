import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
     int [] arr = {3,1,2,4,1,5,2,6,4};
    dividing(arr, 0, arr.length-1);
     System.out.println(Arrays.toString(arr));

    }

    public static void dividing(int []arr,int i, int j){
      if(i==j){
        return;
      } 
      dividing(arr, i, (j+i)/2);
      dividing(arr, (j+i)/2+1, j);
    merging(arr,i,j);
    }

    public static void merging(int[] arr,int low,int high){
      int i = low;
      int mid = (low + high)/2;
      int j =  mid + 1;
      int k = 0;

      int [] temp = new int[arr.length];

      while (i<=mid && j<=high) {
        if (arr[i]==arr[j]) {
            temp[k++]=arr[i++];
           
        }else if(arr[i]>arr[j]){
            temp[k++] = arr[j++];
        }else{
            temp[k++]=arr[i++];
        }
      }

      while (i<=mid) {
        temp[k++] = arr[i++];
      }
      while (j<=high) {
        temp[k++] = arr[j++];
      }
      
      for (int x = 0; x < k; x++) {
        arr[low + x] = temp[x];
    }
    }
}
