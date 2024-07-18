import java.util.Arrays;

public class insertion{
    public static void main(String[] args) {
         int[] arr = { 5, 3, 4, 6, 1, 8, 12, -90, -58 };

  sort(arr);
    System.out.println(Arrays.toString(arr));
    }

    public static void swap(int [ ] arr,int i,int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]=temp;
    }
     public static void sort(int [] arr){
      for (int i =0; i < arr.length-1; i++) {
        for(int j = i+1;j>0;j--){
            if (arr[j]<arr[j-1]) {
                swap(arr, j-1, j);
            }
            else{
                break;
            }
        }
      }
    }
}
