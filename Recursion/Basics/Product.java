public class Product {
    public static int product(int n){
        if(n<2){
            return 1;
        }
        int z=product(n-1);
        return n*z;
    }
    public static void main(String[] args) {
        System.out.println(product(5));
    }
}
