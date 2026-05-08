class Node1 {
    int data;
    Node1 left, right;

    Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

public class KthLevelTree {
    void KthLevel(Node1 root,int k)
    {
        if(root == null)
        {
            return;
        }
        if(k == 1)
        {
            System.out.println(root.data);
            return;
        }
        KthLevel(root.left, k-1);
        KthLevel(root.right, k - 1);
    }
}
