public class FlipTheImage {
    public static void main(String[] args) {
      int [][] arr ={{1,1,0},{1,0,1},{0,0,0}};
     soln(arr);

     for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
               System.out.print(arr[i][j]);
            }
         System.out.println();
        }
     }
    public  static void soln(int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length-1-j];
                arr[i][arr.length-1-j]= temp;
                
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = arr[i][j]^1;
           }
         }
       
    }
}
