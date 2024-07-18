
import java.util.*;

class letterCombinationofPhone {
    public List<String> letterCombinations(String digits) {
       
        List<String> ans = new ArrayList<>();
         if(digits.length()==0) return ans;
        soln("",digits,ans);
        return ans;
    }
    
    public void soln(String p,String up,List<String> ans){
        if(up.length()==0){
          ans.add(p);
          return;
        }
        int digit = up.charAt(0)-'0';//converts '2' to 2
        if(digit<=6){
        for(int i = (digit-2)*3; i<(digit-1)*3;i++){
           char ch = (char)(i+'a');//converts 0 to a, 1 to b and so on....
           soln(p+ch,up.substring(1),ans);
        }
        }

        if(digit==7){
        for(int i = (digit-2)*3; i<=(digit-1)*3;i++){
           char ch = (char)(i+'a');
           soln(p+ch,up.substring(1),ans);
        }
        }
       if(digit==8){
        for(int i = (digit-2)*3+1; i<=(digit-1)*3;i++){
           char ch = (char)(i+'a');
           soln(p+ch,up.substring(1),ans);
        }
        }
        if(digit==9){
        for(int i = 22; i<=25;i++){
           char ch = (char)(i+'a');
           soln(p+ch,up.substring(1),ans);
        }
        }

    }
}