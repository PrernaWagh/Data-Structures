import java.util.*;

class CloneGraph {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node dfs(Node curr, HashMap<Node, Node> map) {
        List<Node> neigh = new ArrayList<>();
        Node clone = new Node(curr.val);
        map.put(curr, clone);
        for (Node it : curr.neighbors) {
            if (map.containsKey(it)) {
                neigh.add(map.get(it));
            } else {
                neigh.add(dfs(it, map));
            }
        }
        clone.neighbors = neigh;
        return clone;
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        if (node.neighbors.isEmpty()) {
            Node clone = new Node(node.val);
            return clone;
        }
        return dfs(node, map);
    }
}