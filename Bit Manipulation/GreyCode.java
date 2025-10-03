import java.util.*;
/*Gray Code (also called Reflected Binary Code) is a binary 
numeral system where two successive values differ in only one bit.
 This property makes Gray Code particularly useful in applications 
 where minimizing errors during transitions is crucial, such as in
  digital systems, encoders,  and communication protocols.
Size 1 (1-bit Gray Code):
["0", "1"]

Size 2 (2-bit Gray Code):
["00", "01", "11", "10"]

Size 3 (3-bit Gray Code):
["000", "001", "011", "010", "110", "111", "101", "100"]

  */
public class GreyCode {
    public static List<String> rec(int n){
    //function that retursn the list of string of grey code of size n
      List<String> ans = new ArrayList<>();
      if(n==0) return ans;
      if(n==1){
        ans.add("0");
        ans.add("1");
      }
      
      List<String> small = rec(n-1);
      for (int i = 0; i < small.size(); i++) {
        ans.add("0" + small.get(i));
      }
      for (int i =small.size()-1 ; i >=0; i--) {
        ans.add("1" + small.get(i));
      }
      return ans;     
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> ans = rec(n);
        for(String st : ans) System.out.println(st);
        sc.close();
    }
}
