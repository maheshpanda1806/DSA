import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
         int [] arr = {5,3,4,6,1,8,12,-90,-58};
         
      sort(arr);
      System.out.println(Arrays.toString(arr));
    }
   public static void sort(int [] arr){
         // run the steps n-1 times
          for (int i = 0; i < arr.length-1; i++) {
             boolean isSorted = true;//let us assume
                         // for each step, max item will come at the last respective index
                         //no point in checking that part
            for (int j = 1; j < arr.length-i; j++) {
                // swap if the item is smaller than the previous item
                if(arr[j]<arr[j-1]){
                    int temp;
                    temp = arr[j];
                    arr[j]= arr[j-1];
                    arr[j-1]= temp;
                    isSorted = false;//assumption will break
                }
           }
            //if assumption is true then it will break the loop coz there is no point checking beyond 
             if(isSorted){
                    break;
                }
          }
    }
}
