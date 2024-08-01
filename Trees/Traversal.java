  class TreeNode {
    int val;
        TreeNode left;
     TreeNode right;
     TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }
public class Traversal {
    public static void preorder(TreeNode root){
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(TreeNode root){
        postorder(root.left);
        postorder(root.right);
        System.out.println(root);
    }
    public static void inorder(TreeNode root){
        inorder(root.left);
        System.out.println(root);
        inorder(root.right);
        
    }
}
