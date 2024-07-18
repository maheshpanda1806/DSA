public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,6,9,10,15};
        System.out.println(search(arr, 10, 0, arr.length-1));
    }
    public static int search(int [] arr,int target, int s , int e){
        
        if (s>e)  return -1;
        int m = s -(s-e)/2;
        if(arr[m]== target) return m;  
      
        if (arr[m]> target) return search(arr,target,s,m-1);
        else return search(arr,target,m+1,e);
    }
}