public class RevAString{
    public static void main(String[] args) {
        String s = rev("Mahesh");
        System.out.println(s);
    }
    public static String rev(String s){
        if (s.length()==1) {
            return s;
        }
        return rev(s.substring(1)) + s.charAt(0);
    }
}