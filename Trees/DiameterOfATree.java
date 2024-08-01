public class DiameterOfATree{
    class Solution {
        public  int maxi;
        public int diameterOfBinaryTree(TreeNode root) {
            maxi = 0;
            int joker=diameter(root);
            return maxi;
        }
        public int diameter(TreeNode root){
            if(root==null) return 0;
            int left = diameter(root.left);
            int right = diameter(root.right);
            int height = Math.max(left,right)+1;
            maxi = Math.max(maxi,left+right);
            return height;
        }
        public static void main(String[] args) {
            
        }
        }
}
