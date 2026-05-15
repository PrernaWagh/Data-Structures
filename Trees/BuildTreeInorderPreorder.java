import java.util.*;
//Definition for a binary tree node.
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
 
public class BuildTreeInorderPreorder {
    public TreeNode buildTree2(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> iMap)
    {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = iMap.get(root.val);
        int numsleft = inRoot - inStart;
        root.left = buildTree2(preorder,preStart + 1,preStart + numsleft,inorder,inStart,inRoot - 1,iMap);
        root.right = buildTree2(preorder,preStart + numsleft+1,preEnd,inorder,inRoot + 1,inEnd,iMap);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree2(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1,map);

        return root;
    }
}