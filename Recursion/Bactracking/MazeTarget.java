public class MazeTarget {
   public static void main(String[] args) {
     boolean[][] arr ={
        {true,true,true},
        {true,true,true},
        {true,false,true},
               
     };
   // int ans = mazeSoln( 3, 3, 1, 2, "");
    int ans1 = mazeSoln(0,0,2,2,"",new boolean[3][3]);
     System.out.println(ans1);
   }
   //returns count and prints path
   public static int mazeSoln(int r,int c,int tr,int tc,String ans){
       if (r==tr && c==tc) {
        System.out.println(ans);
        return 1;
       }
       if (c==tc) {
        int count = mazeSoln( r-1, c, tr, tc, ans+"D");

        return count;
       }
       if(r==tr){
        int count = mazeSoln( r, c-1, tr, tc, ans+"R");
        return count;
       }
         
       int leftCount = mazeSoln(r-1, c, tr, tc, ans+"D");
       int diagnolCount = mazeSoln(r-1, c-1, tr, tc, ans+"L");
       int rightCount = mazeSoln( r, c-1, tr, tc, ans+"R");
       return leftCount+rightCount+diagnolCount;
   }

   public static int mazeSolnObstacles(boolean[][] arr,int r,int c,int tr,int tc,String ans){
    if (!arr[r][c]){
        return 0;
    }
    if (r==tr && c==tc) {
     System.out.println(ans);
     return 1;
    }
    if (c==tc) {
     int count = mazeSolnObstacles( arr,r+1, c, tr, tc, ans+"D");
     return count;
    }

    if(r==tr){
     int count = mazeSolnObstacles(arr, r, c+1, tr, tc, ans+"R");
     return count;
    }
      
    int leftCount = mazeSolnObstacles(arr,r+1, c, tr, tc, ans+"D");
    int diagnolCount=mazeSolnObstacles(arr,r+1, c+1, tr, tc, ans+"L");
    int rightCount = mazeSolnObstacles( arr,r, c+1, tr, tc, ans+"R");
    return leftCount+rightCount+diagnolCount;
}
//
public static int mazeSoln(int r, int c, int tr, int tc, String ans, boolean[][] visited) {
   if (r < 0 || c < 0 || r > tr || c > tc || visited[r][c]) {
       return 0;
   }
   
   if (r == tr && c == tc) {
       System.out.println(ans);
       return 1;
   }
   // i am considering this block in my path
   visited[r][c] = true;

   //
   int downCount= mazeSoln(r + 1, c, tr, tc, ans + "D", visited); // Move down
   int upCount = mazeSoln(r - 1, c, tr, tc, ans + "U", visited); // Move up
   int rightCount = mazeSoln(r, c + 1, tr, tc, ans + "R", visited); // Move right
   int leftCount = mazeSoln(r, c - 1, tr, tc, ans + "L", visited); // Move left

    // this line is where the function will be over
   // so before the function gets removed, also remove the changes that were made by that function this os caloed bactracking
   visited[r][c] = false;

   return downCount+upCount+rightCount+leftCount;
}

}