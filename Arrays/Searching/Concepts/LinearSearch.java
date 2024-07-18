package Concepts;
public class LinearSearch {
    public static void main(String[] args) {
        int [] arr = {2,4,5,9,11,12,14,36,36,48};
        int [] arr2 = {48,36,20,14,12,11,9,5,4,2};
        System.out.println(answer(arr, 36));//8
        System.out.println(answer(arr, 6));//-1
        System.out.println();
        System.out.println(answer(arr2, 14));//4
        System.out.println(answer(arr2, 0));///-1
    }
    public static int answer(int [] arr, int target){
        for(int i =0;i<arr.length;i++){
            if(arr[i]== target){
                return i;
            }
        }
        return -1;
    }
}
