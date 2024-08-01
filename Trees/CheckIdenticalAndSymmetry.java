public class CheckIdenticalAndSymmetry {
    
class Solution {
    //Identical
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        if(p.val!=q.val) return false;
        boolean left = isSameTree(p.left,q.left);
        if(!left) return false;
        boolean right = isSameTree(p.right,q.right);
        if(!right) return false;

        return true;

    }
     //symmetricity
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return soln(root.left, root.right);

    }
    public boolean soln(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        if(p.val!=q.val) return false;
        boolean left = isSameTree(p.left,q.left);
        if(!left) return false;
        boolean right = isSameTree(p.right,q.right);
        if(!right) return false;

        return true;
    }
}
}
