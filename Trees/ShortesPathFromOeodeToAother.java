public class ShortesPathFromOeodeToAother {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private void rootToNode(TreeNode root, int n, int m, StringBuilder temp, StringBuilder s, StringBuilder d) {
        if (root == null) return;

        if (root.val == n) s.append(temp);
        if (root.val == m) d.append(temp);

        temp.append('L');
        rootToNode(root.left, n, m, temp, s, d);
        temp.deleteCharAt(temp.length() - 1);

        temp.append('R');
        rootToNode(root.right, n, m, temp, s, d);
        temp.deleteCharAt(temp.length() - 1);
    }

    public String getDirections(TreeNode root, int n, int m) {
        StringBuilder s = new StringBuilder(), d = new StringBuilder(), temp = new StringBuilder();
        rootToNode(root, n, m, temp, s, d);

        int ind = 0;
        for (int i = 0; i < s.length() && i < d.length(); i++) {
            if (s.charAt(i) == d.charAt(i)) ind = i + 1;
            else break;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = ind; i < s.length(); i++) {
            ans.append('U');
        }
        for (int i = ind; i < d.length(); i++) {
            ans.append(d.charAt(i));
        }

        return ans.toString();
    }
}

}
