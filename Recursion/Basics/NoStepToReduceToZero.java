public class NoStepToReduceToZero {
    public static void main(String[] args) {
    System.out.println(numberOfSteps(8));
    }
    public static int numberOfSteps(int n) { 
        return steps(n, 0);
      }
      static int steps(int n,int count){
       if(n==0){
          return count ;
       }
      
       if ((n&1)==0){
          return steps(n/2,++count);
       }else{
          return steps(n-1,++count);
       }
      }
    
}
