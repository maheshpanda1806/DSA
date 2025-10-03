public class CheckBalancedTree {
    class Solution {
    boolean balanced; 
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        rec(root);
        return balanced;
    }
    public int rec(TreeNode root){
        if(root==null) return 0;

        int left = rec(root.left);
        int right = rec(root.right);
        if(Math.abs(left-right)>1) balanced = false;

        return 1 + Math.max(left,right);
    }
}
    
}
