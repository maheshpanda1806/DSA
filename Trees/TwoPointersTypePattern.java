public class TwoPointersTypePattern {
    
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

//easy wala - check flip equivalent
class Solution2 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null) return false;
        if(root2==null) return false;

        if(root1.val!=root2.val) return false;

        boolean left =  flipEquiv(root1.left,root2.left);
        boolean right = flipEquiv(root1.right,root2.right);
        if(left && right) return true;

        boolean left1 =  flipEquiv(root1.left,root2.right);
        boolean right1 = flipEquiv(root1.right,root2.left);
        if(left1 && right1) return true;

        return false;
    }
}
