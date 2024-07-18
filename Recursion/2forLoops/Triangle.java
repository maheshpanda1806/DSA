public class Triangle {
    public static void main(String[] args) {
    
    }
    public static void printTriangle(int r){
        printStar(0, 0, r);
    }
    public static void printStar(int i,int j,int r){
        if (i>r) {
            return;
        }
        if ((i+j)>r) {
           System.out.println();
           printStar(i+1, 0, r); 
        }else{
            System.out.print("*");
            printStar(i, j+1, r);
        }
    }
}
