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
public class CeilFloorInBST{
    public int ceilInBST(TreeNode root,int key)
    {
        int ceil = -1;
        while(root != null)  
        {
            if(root.val == key)
            {
                ceil = root.val;
                return ceil;
            }
            if(key > root.val) 
            {
                ceil = root.val;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return ceil;
    }
    public int floorInBST(TreeNode root,int key) 
    {
        int floor = -1;
        while(root != null)   
        {
            if(root.val == key) 
            {
                floor = root.val;
                return floor;
            }
            if(key > root.val)  
            {
                floor = root.val;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
    }
}