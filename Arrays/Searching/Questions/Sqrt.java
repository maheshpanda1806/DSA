//package Questions;
import java.util.*;

public class Sqrt {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int [] arr = new int[target+1];
        for(int i=0;i<=target;i++){
            arr[i] = i;
        }
       System.out.println(search(arr, target));
    }
    public static int search(int [] arr, int target){
        int s = 0;
        int e = arr.length -1;
        while(e>=s){
            int mid = s -(s-e)/2 ;
            if(target>mid*mid){
                s = mid +1;
            }
            else if(target<mid*mid){
                e= mid -1;
            }
            else{
                return mid;
            }

        }
        return e;

    }
}
