import java.util.ArrayList;

public class PathSumPrint {
    
class Solution
{   static ArrayList<ArrayList<Integer>> ans;
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        ans = new ArrayList<>();
        rec(root,sum,new ArrayList<>());
        return ans;
    }
    public static void rec(Node root,int sum,ArrayList<Integer> ds){
        if(root==null) return;
        if(sum==root.data){
            ds.add(root.data);
            ans.add(new ArrayList<>(ds));
            ds.remove(ds.size()-1);
            
        }
      
        ds.add(root.data);
        rec(root.left,sum-root.data,ds);
        rec(root.right,sum-root.data,ds);
        ds.remove(ds.size()-1);
      
        
    }
}
}
