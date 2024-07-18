import java.util.Arrays;

public class RevString {
    public static void main(String[] args) {
        rev("Mahesh");

    }
    public static void rev(String s){
        char [] arr = s.toCharArray();
        rev(arr,0,s.length()-1);
        String st= "";
        for (int i = 0; i < arr.length; i++) {
            st+=arr[i];
        }
        System.out.println(st);
    }
    public static void rev(char[]s,int i,int j){
        if ( i>=j) {
            return;
        }
        char temp = s[i];
        s[i]=s[j];
        s[j]=temp;
       rev(s,++i,--j);
    }
}
