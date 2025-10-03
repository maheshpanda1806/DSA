public class Basics{
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println(binaryToInt("1111"));
    }
    public static String func(int x){
        StringBuilder s = new StringBuilder();
        int num = x;
        while (num>0) {
            s.append(num%2);
            num = num/2;
        }
        return s.reverse().toString();
    }
    public static int binaryToInt(String s){
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1') ans+=(int) Math.pow((double)2,(double)s.length()-i-1);
        }
        return ans;
    }
}