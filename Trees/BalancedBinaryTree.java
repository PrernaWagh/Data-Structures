
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalancedBinaryTree {
    // brute force approach O(N^2)
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftht = findHeight(root.left);
        int rightht = findHeight(root.right);

        if (Math.abs(rightht - leftht) > 1)
            return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if (!left || !right)
            return false;

        return true;
    }

    //optimal approach O(N)
    public int findHeight2(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int lh = findHeight2(root.left);
        int rh = findHeight2(root.right);
        if(lh == -1 || rh == -1) return -1;
        if(Math.abs(lh -rh) > 1) return -1;
        return Math.max(lh,rh) + 1;
    }
    public boolean isBalanced2(TreeNode root)
    {
        return findHeight2(root) != -1;
    }
}