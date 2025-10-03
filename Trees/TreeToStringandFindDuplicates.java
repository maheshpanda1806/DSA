public class TreeToStringandFindDuplicates {
    //string method --beats 12 percent
class Solution {
    public String tree2str(TreeNode root) {
        if(root==null) return "";

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if(left!="" && right!="") return root.val + "" +'('+left+')'+'('+right+')';
        if(left!="") return root.val + "" +'('+left+')';
        if(right!="") return root.val + "()"  +'('+right+')';

        return root.val+"";
    }

}

//using stringBuilder --100% beats
class Solution2 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val);

        if (root.left != null || root.right != null) {
            sb.append('(');
            buildString(root.left, sb);
            sb.append(')');

            if (root.right != null) {
                sb.append('(');
                buildString(root.right, sb);
                sb.append(')');
            }
        }
    }
}

}

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
class Solution3 {
    Map<String, Integer> map;
    List<TreeNode> list;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();
        rec(root);
        return list;
    }
    public String rec(TreeNode root){
        if(root==null) return "";
        
        String left = rec(root.left);
        String right = rec(root.right);
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append('L');
        for(int i =0;i<left.length();i++) sb.append(left.charAt(i));
        sb.append('R');
        for(int i =0;i<right.length();i++) sb.append(right.charAt(i));
        String ans = sb.toString();
       
        map.put(ans,map.getOrDefault(ans,0)+1);
        if(map.get(ans)==2) list.add(root);        
        return ans ;
    }
}
