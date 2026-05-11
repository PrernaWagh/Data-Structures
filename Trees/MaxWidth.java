//max width of a binary tree

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    class Pair {
        int num;
        TreeNode node;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        int size = 0;
        int min = 0;
        int first = 0;
        int last = 0;
        int cur_id = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            size = q.size();
            min = q.peek().num;
            for (int i = 0; i < size; i++) {
                cur_id = q.peek().num - min;
                TreeNode node = q.peek().node;
                q.poll();

                if (i == 0)
                    first = cur_id;
                if (i == size - 1)
                    last = cur_id;
                if (node.left != null) {
                    q.offer(new Pair(node.left, cur_id * 2 + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, cur_id * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
