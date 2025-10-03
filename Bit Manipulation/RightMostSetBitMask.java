public class RightMostSetBitMask {
    public static void main(String[] args) {
        int n = 76;
        int rsbm = n&-n;
        System.out.println(Integer.toBinaryString(rsbm));
    }
}
