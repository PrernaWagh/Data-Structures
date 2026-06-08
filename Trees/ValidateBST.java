
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

public class ValidateBST {
    public boolean isValidBST1(TreeNode root,long min,long max)
    {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        
        return isValidBST1(root.left,min,root.val) && isValidBST1(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}