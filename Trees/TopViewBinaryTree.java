import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair {
    Node node;
    int hd; // horizontal distance

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewBinaryTree {
    //TC = O(N log N) as using Treemap replace with hashmap for O(N)
    //SC = O(N) +O(N)
    public static void topView(Node root) {
        if (root == null) return;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // push root with horizontal distance 0
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Node curr = temp.node;
            int hd = temp.hd;

            // store first node for each horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, curr.data);
            }

            if (curr.left != null) {
                q.offer(new Pair(curr.left, hd - 1));
            }

            if (curr.right != null) {
                q.offer(new Pair(curr.right, hd + 1));
            }
        }

        // print top view
        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        /*
                1
              /   \
             2     3
              \   / \
               4 5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        topView(root); // Output: 2 1 3 6
    }
}