public class TwoPointerPallindrome {
    public static void main(String[] args) {
        System.out.println(isPallindrome(""));
    }
    public static boolean isPallindrome(String s) {
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
