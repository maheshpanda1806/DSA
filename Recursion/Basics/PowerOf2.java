public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(powOf3WithoutRecursion(81));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        boolean h = n % 2 == 0;
        boolean g = isPowerOfTwo(n / 2);
        return (g && h);
    }

    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        boolean h = n % 4 == 0;
        boolean g = isPowerOfFour(n / 4);
        return (h && g);
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        boolean h = n % 3 == 0;
        boolean g = isPowerOfThree(n / 3);
        return (h && g);
    }

    public static boolean powOf3WithoutRecursion(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {

            if (n == 1) {
                return true;
            }
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }

}
