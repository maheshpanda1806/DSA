package Concepts;
public class BinarySearch{
    public static void main(String[] args) {
        int [] arr = {2,2,5,9,11,12,14,20,36,48};
        int [] arr2 = {48,36,20,14,12,11,9,5,4,2};
       System.out.println(ascending(arr, 2));//8
       System.out.println(ascending(arr, 6));//-1
       System.out.println();
       System.out.println();
       System.out.println(descending(arr2, 11));//1
       System.out.println(descending(arr2, 0));///-1

    }
      
    public static int ascending(int [] arr, int target){
        int s = 0;
     
        int e =arr.length -1;
     

        while(e>= s){
            int mid = s - (s-e)/2;

            if(target>arr[mid]){
                s = mid +1;

            }
            else if(target<arr[mid]){
                e = mid -1;
            }
            else{
                //answer found 
                return mid;
            }
        }
        //answer not found
       return -1;
    }

    public static int descending(int [] arr, int target){
        int s = 0;
     
        int e =arr.length -1;
     

        while(e>= s){
            int mid = s - (s-e)/2;
            if(target>arr[mid]){
                e = mid -1;

            }
            else if(target<arr[mid]){
                s = mid +1;
            }
            else{
                //answer found 
                return mid;
            }
        }
        //answer not found
       return -1;
    }
}