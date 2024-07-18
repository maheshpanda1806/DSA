import java.util.*;

public class Cyclic {
  public static void main(String[] args) {
    int[] arr = {3,5,2,1,4};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] arr) {
    int i = 0;
    while (i < arr.length) {

      if (arr[i] != 1+i) {
       swap(arr, i, arr[i] -1);
      }
      else {
        i++;
      }
    }
   
  }

  public static void swap(int[] arr, int i,int j){
    int temp= arr[i];
    arr[i]= arr[j];
    arr[j] = temp;
  }
}
