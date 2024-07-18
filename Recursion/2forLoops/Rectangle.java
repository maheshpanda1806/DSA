public class Rectangle {
    public static void main(String[] args) {
   
    }
    public static void printRectangle(int r,int c){
    printStar(0,0,r,c);
    }
    public static void printSquare(int r){
    printStar(0,0,r,r);
    }
    private static void printStar(int i, int j, int r, int c) {
        if (i > r ) {
            return;
        }
        if (j > c) {
            System.out.println();
            printStar(i + 1, 0, r, c);
        } else {
            System.out.print("*");
            printStar(i, j + 1, r, c);
        }
    }
}
