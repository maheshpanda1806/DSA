public class SkipCharacter {
    public static void main(String[] args) {
        System.out.println(skip2('c', "baccadcc",""));
    }

    public static String skip(char a, String str) {
        return skip(a, str, "");
    }
    
    public static String skip2(char a, String str) {
        return skip2(a, str, "");
    }

    private static String skip(char a, String str, String ans) {
        if (str.length() == 1) {
            if (str.charAt(0) == a) {
                return ans;
            } else {
                return ans + str.charAt(0);
            }
        }
        String temp = str.substring(1);
        if (str.charAt(0) == a) {
            return ans + skip(a, temp, ans);
        } else {
            return ans + str.charAt(0) + skip(a, temp, ans);
        }
    }

     private static String skip2(char a, String str, String ans) {
        if (str.length() == 0) {
         return ans;   
        }
        String temp = str.substring(1);
        if (str.charAt(0) == a) {
            return skip2(a, temp, ans);
        } else {
            return skip2(a, temp, ans + str.charAt(0));
        }
    }
}