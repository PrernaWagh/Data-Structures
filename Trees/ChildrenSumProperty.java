class TreeNode<T> {
    int val;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ChildrenSumProperty {

    public static void changeTree(TreeNode<Integer> root) {

        if (root == null)
            return;

        int child = 0;

        if (root.left != null) {
            child += root.left.val;
        }

        if (root.right != null) {
            child += root.right.val;
        }

        // If children sum is greater, update root
        if (child >= root.val) {
            root.val = child;
        } 
        // Otherwise push parent value to children
        else {
            if (root.left != null) {
                root.left.val = root.val;
            }

            if (root.right != null) {
                root.right.val = root.val;
            }
        }

        // Recursive calls
        changeTree(root.left);
        changeTree(root.right);

        // Backtracking step
        int tot = 0;

        if (root.left != null) {
            tot += root.left.val;
        }

        if (root.right != null) {
            tot += root.right.val;
        }

        // Update root with children sum
        if (root.left != null || root.right != null) {
            root.val = tot;
        }
    }
}