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

public class InsertBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    TreeNode buildBST(int arr[])
    {
        TreeNode root = null;
        for(int val:arr)
        {
            root = insertIntoBST(root, val);
        }
        return root;
    }
    void inorder(TreeNode root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }
    }
    public static void main(String s[]) {
        int arr[] = { 3, 2, 1, 5, 6, 7 };
        InsertBST b1 = new InsertBST();
        TreeNode root = b1.buildBST(arr);

        b1.inorder(root);
    }
}