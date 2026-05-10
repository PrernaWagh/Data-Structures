public class MaxPathSum {
       public int maxPath(TreeNode root,int max[])
    {
        if(root == null)
        {
            return 0;
        }
        int left = Math.max(0,maxPath(root.left,max));
        int right = Math.max(0,maxPath(root.right,max));

        max[0] = Math.max(max[0],left + right + root.val);
        return Math.max(left,right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root,maxValue);

        return maxValue[0];
    }
}
