public class SubTree { 
class Solution {
    boolean ans;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ans = false;
        traverse(root,subRoot);
        return ans;
    }
    public void traverse(TreeNode root,TreeNode s){
        if(root==null) return;

        ans =  rec(root,s);
        if(ans==true) return;
        if(!ans) traverse(root.left,s);
        if(!ans) traverse(root.right,s);
    }
    public boolean rec(TreeNode root,TreeNode s){
        if(root==null && s==null) return true;
        if(root==null) return false;
        if(s==null) return false;

        if(root.val!=s.val) return false; 
        
        boolean left = rec(root.left,s.left);
        if(!left) return false;
        boolean right = rec(root.right,s.right);
        if(!right) return false;

        return true;
    }
 }
}
