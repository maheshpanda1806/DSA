public class IsSorted {
    public static void main(String[] args) {
     int [] arr ={1,2,3,12,5,6};
     System.out.println(Check(arr, 1));
    }
    public static boolean Check(int [] arr,int i){
      if (i==arr.length-1) {
        return true;
      }
      if (arr[i-1]>arr[i]) {
        return false;
      }
     
      return arr[i-1]<arr[i] && Check(arr, i+1);
    }  
}
