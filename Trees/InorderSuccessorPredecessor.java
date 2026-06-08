
public class InorderSuccessorPredecessor {
    class TreeNode  {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode()
    {

    }
    TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
    public int inorderSuccessor(TreeNode root)
    {
        int ans = 0;
        while(root != null)
        {
            ans = root.val;
            root = root.left;
        }
        return ans;
    }
    public int inorderPredecessor(TreeNode root) 
    {
        int ans = 0;
        while(root != null)
        {
            ans = root.val;
            root = root.right;
        }
        return ans;
    }
    public int[] inorderPredecessorSuccessor(TreeNode root,int key)
    {
        int succ = -1;
        int pred = -1;
        while(root != null)
        {
            if(key < root.val)
            {
                succ = root.val;
                root = root.left;
            }
            else if(key > root.val)
            {
                pred = root.val;
                root = root.right;
            }
            else{
                pred = inorderPredecessor(root.left);
                succ = inorderSuccessor(root.right);
            }
        }
        return new int[]{pred,succ};
    }
}
