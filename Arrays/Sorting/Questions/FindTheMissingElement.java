package Questions;

import java.util.Arrays;

public class FindTheMissingElement {
    public static void main(String[] args) {
        int [] arr = {5,4,2,1,0};
         sort(arr);
     // System.out.println(Arrays.toString(arr));
    }
    public static void sort(int [] arr){
        int i=0;
       while (i<arr.length) {
         if(arr[i]!=i){
            swap(arr,i,arr[i]);
        }
        else{
            i++;
        }
       }
    }
    
    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
   arr[i] = arr[j];
   arr[j] = temp;
}
}
