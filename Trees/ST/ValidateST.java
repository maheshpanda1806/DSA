
class Solution {
    
    long preVal= Long.MIN_VALUE ;

    // lets declare one global isValid variable and set it to true;
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        
        inorder(root);
        return isValid;
    }
    //this is basic inorder traversal
    public void inorder(TreeNode root){

        if(root == null) return ;
        //goto left ...
        inorder(root.left);

        //here we will check if previous value is greater than or equal to current value 
        //if its equal or greater then this is not valid tree...
        if(preVal>=root.val)isValid = false;
        preVal = root.val;

        // goto right ...
        inorder(root.right);
    }
}