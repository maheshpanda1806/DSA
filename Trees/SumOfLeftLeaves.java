import javax.swing.tree.TreeNode;
//float  //teaches us How To Use Flags For Idetification Of Left Or Right Child;
public class SumOfLeftLeaves { 
    class Solution {
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left==null && root.right==null){
            return 0;
        }
        sum=0;
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root,int flag){
       if(root==null) return;
       
       if(root.left==null && root.right==null){
        if(flag==0) sum+=root.val;
        return;
       }
       helper(root.left,0);
       helper(root.right,1);
    }
}

}
