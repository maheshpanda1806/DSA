public class SkipString {
    public static void main(String[] args) {
        System.out.println(skipSoln("apple", "applesMaheshjokerapplesapple"));
    }
    public static String skipSoln(String skp, String str) {
    return skipSoln(skp, str, "");
    }
    private static String skipSoln(String skp, String str, String ans) {
        if (skp.length() == 1) {
            return soln(skp.charAt(0), str);
        }
        if (str.length() == 1) {
            return ans + str.charAt(0);
        }
        if (str.charAt(0) == skp.charAt(0) && skp.length() < str.length()) {
            String suString = str.substring(0, skp.length());
            int x = suString.compareTo(skp);
            if (x == 0) {
                return ans + skipSoln(skp, str.substring(skp.length()), ans);
            }
        } else if (str.charAt(0) == skp.charAt(0) && skp.length() == str.length()) {
            return ans;
        }
       
        return ans + str.charAt(0) + skipSoln(skp, str.substring(1), ans);
        
    }

    public static String soln(char a, String str) {
        return soln(a, str, "");
    }

    private static String soln(char a, String str, String ans) {
        if (str.length() == 1) {
            if (str.charAt(0) == a) {
                return ans;
            } else {
                return ans + str.charAt(0);
            }
        }
        String temp = str.substring(1);
        if (str.charAt(0) == a) {
            return ans + soln(a, temp, ans);
        } else {
            return ans + str.charAt(0) + soln(a, temp, ans);
        }
    }
}
