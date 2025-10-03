public class CheckFlipBTpossibleOrNot {
    /*951. Flip Equivalent Binary Trees
Solved
Medium
Topics
Companies
For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.

 

Example 1:

Flipped Trees Diagram
Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Example 2:

Input: root1 = [], root2 = []
Output: true
Example 3:

Input: root1 = [], root2 = [1]
Output: false*/
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return check(root1, root2);
    }

    public boolean check(TreeNode x, TreeNode y) {
        if (x == null && y == null)
            return true;
        if (x == null)
            return false;
        if (y == null)
            return false;

        int xLeft = getVal(x.left);
        int xRight = getVal(x.right);

        int yLeft = getVal(y.left);
        int yRight = getVal(y.right);

        if ((xLeft != yLeft || xRight != yRight) && (xLeft != yRight || xRight != yLeft)) {
            return false;
        }
        boolean swap = (xLeft == yRight || xRight == yLeft);
        if (swap) {
            boolean left = check(x.left, y.right);
            if (!left)
                return false;
            boolean right = check(x.right, y.left);
            if (!right)
                return false;
        } else {
            boolean left = check(x.left, y.left);
            if (!left)
                return false;
            boolean right = check(x.right, y.right);
            if (!right)
                return false;
        }

        return true;

    }

    public int getVal(TreeNode root) {
        if (root == null)
            return 0;
        else
            return root.val;
    }
}
}

//easy wala
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
