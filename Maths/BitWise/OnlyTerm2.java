public class OnlyTerm2 {
    //wrong hai thik kar....
    public static void main(String[] args) {
        int [] arr ={2,2,2,3,3,3,7,7,7,8,8,8,5};
        System.out.println(soln(arr));
    }
    public static int soln(int []arr){
      int sum=0;
      int i=0;
      while(arr.length>i){
        sum += arr[i];
      i++;
      }
      return 0 ;
    }
}
