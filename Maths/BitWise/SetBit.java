public class SetBit {
    public static void main(String[] args) {
        System.out.println(soln(5, 2));
    }
    public static int soln(int n,int m){
      int ans =(n|(1<<(m-1))); 
       return ans;
    }
}
