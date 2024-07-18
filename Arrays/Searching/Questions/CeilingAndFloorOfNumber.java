//package Questions;
// The ceiling function of a real number is the least integer number greater than or equal to the given number. In the case of 4.5, the integers greater than 4.5 are 5, 6, 7, 8, ….. The smallest of all is 5.
import java.util.*;
public class CeilingAndFloorOfNumber {
    public static void main(String[] args) {
        int [] arr = {2,2,5,9,11,12,14,20,36,48};
        Scanner sc = new Scanner(System.in);
        int target = 4;
        System.out.println(answer(arr,target));
     System.out.println(arr[answer(arr, target)]);
    }
     //e>=s means it will stop when e<s or run till e>=s
    public static int answer(int [] arr, int target){
    int s =0;
    int e = arr.length-1;
    while(e>=s){

        int mid = s -(s-e)/2;

        if(target>arr[mid]){
            s = mid +1;
        }

        else if(target<arr[mid]){
            e= mid -1;
        }
        
        else{
            return mid;
        }

    }
        return s;
    }

}


 class FloorOfNumber {
    public static void main(String[] args) {
        int [] arr = {2,4,5,9,11,12,14,20,36,48};
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        System.out.println(answer(arr,target));
        
        System.out.println(arr[answer(arr, target)]);
    }
     
    public static int answer(int [] arr, int target){
    int s =0;
    int e = arr.length;
    while(e>=s){

        int mid = s -(s-e)/2;

        if(target>arr[mid]){
            s = mid +1;
        }

        else if(target<arr[mid]){
            e= mid -1;
        }
        
        else{
            return mid;
        }

    }
        return e;
    }

}
