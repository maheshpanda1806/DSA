import java.util.*;
public class Permutation {
    public static void main(String[] args) {
    System.out.println(solnList("Maesh",""));  
    }

    public static void soln(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
      for (int i = 0; i <ans.length()+1; i++) {
        soln(str.substring(1),ans.substring(0, i) + ch + ans.substring(i));
      }
    }
      public static ArrayList<String> solnList(String str, String ans) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 0) {
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
      for (int i = 0; i <ans.length()+1; i++) {
       list.addAll(solnList(str.substring(1),ans.substring(0, i) + ch + ans.substring(i)));
      }
     return list;
    }
}