import java.util.ArrayList;
public class SubSequnce {
    public static void main(String[] args) {
     System.out.println(subsets1("","Maheshp"));
    }
    public static void subsets(String up){
        subsets("", up);
    }
    private static void subsets(String p,String up ){
     if (up.length()==0) {
        System.out.println(p);
        return;
     }
     subsets(p, up.substring(1));
     subsets(p+ up.charAt(0), up.substring(1));
    }    

    public static ArrayList<String>  subsets1(String p,String up){
     if (up.length()==0) {
        ArrayList<String> al = new ArrayList<>();
        al.add(p);
        return al;
     }
     ArrayList<String> al1 = subsets1(p, up.substring(1));
     ArrayList<String> al2 = subsets1(p+ up.charAt(0), up.substring(1));
       al1.addAll(al2);
       return al1;
    }      
}
