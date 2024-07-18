import java.util.*;
public class RepeatedDnaSequence {
   public static void main(String[] args) {
     String st = "AAAAAAAAAAAAA";
     //System.out.println(st.substring(0,6));
     System.out.println(findRepeatedDnaSequences(st));
   } 
   public static List<String> findRepeatedDnaSequences(String s){
    HashSet<String> hs = new HashSet<>();
    int i = 0;
    int j = 9;
    HashSet<String> ans = new HashSet<>();

    for(j = 9;j<s.length();j++){
        String temp = s.substring(i,j+1);
        if(!hs.contains(temp)){
           hs.add(temp);
           
        }else{
           ans.add(temp);

        }
        i++;
    }
    List<String> ans2 = new ArrayList<>();
    for (String string : ans) {
        ans2.add(string);
    }
    return ans2;
}
}

