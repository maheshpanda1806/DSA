public class SumOfN {
    public static int sum(int n){
    if(n<2){
        return n;
    }

    return n+sum(n-1);
}
public static void main(String[] args) {
    System.out.println(sum(0));
}
}
