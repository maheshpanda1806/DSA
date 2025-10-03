class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder ds = new StringBuilder();
        rec(ds,ans,n,0,0,0);
        return ans;
    }
    public void rec(StringBuilder ds,List<String> ans,int n,int i,int left,int right){
      if(i==2*n){
        if(valid(ds)){
            ans.add((new StringBuilder(ds)).toString());
        }
        return;
      }
     
     if(left<n){
      ds.append('(');
      rec(ds,ans,n,i+1,left+1,right);
      ds.delete(ds.length()-1,ds.length());
     }
      if(left>right){
       ds.append(')');
      rec(ds,ans,n,i+1,left,right+1);
      ds.delete(ds.length()-1,ds.length());
      }
    }
    public static boolean valid(StringBuilder ds) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ds.length(); i++) {
            char ch = ds.charAt(i);
            
            if (ch == '(') {
                stack.push(ch);
            } 
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;  
                }
                stack.pop(); 
            }
        }
        
        return stack.isEmpty();  
    }
}