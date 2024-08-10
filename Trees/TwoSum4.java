import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class TwoSum4 {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> l=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        return help(root,k);
    }
    public boolean help(TreeNode root,int k )
    {
        if(root==null)return false;
        if(l.contains(k-root.val))return true;
        l.add(root.val);
        return help(root.left,k)||help(root.right,k);
    }
}
}
