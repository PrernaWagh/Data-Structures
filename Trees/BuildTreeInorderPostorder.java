//construct a binary tree from given inorder and postorder
import java.util.*;

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
 
public class BuildTreeInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0 ;i< inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return buildTreeInPost(inorder,0,inorder.length - 1,postorder,0,postorder.length - 1,map);
    }
    public TreeNode buildTreeInPost(int inorder[],int is,int ie,int postorder[],int ps,int pe,HashMap<Integer,Integer> map)
    {
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = map.get(root.val);
        int numsleft = inRoot - is;

        root.left = buildTreeInPost(inorder,is,inRoot - 1,postorder,ps,ps + numsleft -1 ,map);
        root.right = buildTreeInPost(inorder,inRoot + 1,ie,postorder,ps+numsleft,pe - 1,map);

        return root;
    }
}