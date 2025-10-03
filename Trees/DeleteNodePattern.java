import java.util.*;
public class DeleteNodePattern {
    class Solution {
        //dfs postorder
        public TreeNode pruneTree(TreeNode root) {
            if (root == null) return null;
    
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            
            // If both left and right subtrees are pruned away (null) and the current node's value is 0, prune this node as well
            if (root.val == 0 && root.left == null && root.right == null) {
                return null;
            }
            return root;
        }
        public TreeNode removeLeafNodes(TreeNode root, int val) {
            if(root==null) return null;
    
           root.left=removeLeafNodes(root.left,val);
           root.right=removeLeafNodes(root.right,val);
    
           if(root.val==val && root.left==null && root.right==null){
            return null;
           }
           return root;
        }

        //new question
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> ans = new ArrayList<>();
            HashSet<Integer> toDel = new HashSet<>();
            for(int i : to_delete){
                toDel.add(i);
            }
            TreeNode head = del(root,ans,toDel);
            if(head!=null) ans.add(head);
            return ans;
        }
        public TreeNode del(TreeNode root,List<TreeNode> ans,HashSet<Integer> toDel){
           if(root==null) return null;
    
           root.left=del(root.left,ans,toDel);
           root.right=del(root.right,ans,toDel);
    
           if(toDel.contains(root.val)){
            if(root.left!=null) ans.add(root.left);
            if(root.right!=null) ans.add(root.right);
            return null;
           }
           return root;
        }
    }
    //Find Leaf nodes LC
    class Solution {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // ans[i] stores all nodes with a level of i
        public int dfs(TreeNode u) {
            if (u == null) {
                return -1;
            }
            int leftLevel = dfs(u.left);
            int rightLevel = dfs(u.right);
            int currentLevel = Math.max(leftLevel, rightLevel)+ 1; // calculate level of current node
            while (ans.size()<= currentLevel) { // create more space in ans if necessary
                ans.add(new ArrayList<Integer>());
            }
            ans.get(currentLevel).add(u.val);
            return currentLevel;
        }
        public List<List<Integer>> findLeaves(TreeNode root) {
            dfs(root);
            return ans;
        }
    }

    //del Half Node gfg 

class Solution {
    public Node RemoveHalfNodes(Node root) {
        if(root==null) return root;
        
        Node left = RemoveHalfNodes(root.left);
        Node right = RemoveHalfNodes(root.right);
        
        root.left = left;
        root.right = right;
        if(left!=null && right==null) return left;
        if(right!=null && left==null) return right;
        
        return root;
        
    }
}


}
