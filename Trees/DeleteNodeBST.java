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
class DeleteNodeBST {
    public TreeNode getInorderS(TreeNode root)
    {
        while(root != null && root.left != null)
        {
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        }
        else if(val > root.val)
        {
            root.right = deleteNode(root.right, val);
        }
        else{
            //root.val == key
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                //2 children
                TreeNode inorderSuccessor = getInorderS(root.right);
                root.val = inorderSuccessor.val;
                root.right = deleteNode(root.right, inorderSuccessor.val);
            }
        }
        return root;
    }
}