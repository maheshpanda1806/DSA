public class KthSmallestElementInBST {

  public class TreeNode {
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
 

class Solution {
    //Inorder gives a sorted list then select the kth element (Hahahahahhahah) *laughing emoji*
    int count;
    int ans;
   public int kthSmallest(TreeNode root, int k) {
       count =0;
       ans=0;
       inorder(root,k);
       return ans;
   }
   public void inorder(TreeNode root,int k){
       if(root==null) return;
       inorder(root.left,k);
       //sout
       count++;
       if(count == k){
         ans = root.val;
         return;
       }
       inorder(root.right,k);
   }
 }
}
