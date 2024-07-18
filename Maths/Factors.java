import java.util.ArrayList;

public class Factors {
   public static void main(String[] args) {
     ArrayList<Integer> list = soln(20);
     list.sort(null);
      for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
      }
    }
   public static ArrayList<Integer> soln(int n){
    ArrayList<Integer> list = new ArrayList<Integer>();
     for (int i = 1; i*i <n ; i++) {
        if (n%i==0) {
            if (n/i==i) {
                list.add(i);
            }
            else{
                list.add(i);
                list.add(n/i);
            }
        }
     }    
    return list;
   }

}
