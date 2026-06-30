import java.util.*;

// Trie Node
class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}

// Trie
class Trie {
    private Node root;

    Trie() {
        root = new Node();
    }

    // Insert number into Trie
    public void insert(int num) {
        Node node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (!node.containsKey(bit))
                node.put(bit, new Node());

            node = node.get(bit);
        }
    }

    // Maximum XOR with num
    public int findMax(int num) {
        Node node = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (node.containsKey(1 - bit)) {
                maxXor |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxXor;
    }
}

public class MaxXorQueries {

    public static int[] maxXOR(int[] arr, int[][] queries) {

        Arrays.sort(arr);

        int m = queries.length;

        // offlineQuery = {mi, xi, originalIndex}
        int[][] offlineQuery = new int[m][3];

        for (int i = 0; i < m; i++) {
            offlineQuery[i][0] = queries[i][1]; // mi
            offlineQuery[i][1] = queries[i][0]; // xi
            offlineQuery[i][2] = i;             // original index
        }

        Arrays.sort(offlineQuery, Comparator.comparingInt(a -> a[0]));

        Trie trie = new Trie();

        int[] ans = new int[m];
        Arrays.fill(ans, -1);

        int ind = 0;
        int n = arr.length;

        for (int i = 0; i < m; i++) {

            int mi = offlineQuery[i][0];
            int xi = offlineQuery[i][1];
            int originalIndex = offlineQuery[i][2];

            while (ind < n && arr[ind] <= mi) {
                trie.insert(arr[ind]);
                ind++;
            }

            if (ind != 0) {
                ans[originalIndex] = trie.findMax(xi);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Queries input
        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        int[][] queries = new int[q][2];

        System.out.println("Enter queries (xi mi):");

        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt(); // xi
            queries[i][1] = sc.nextInt(); // mi
        }

        int[] ans = maxXOR(arr, queries);

        System.out.println("\nAnswers:");

        for (int x : ans)
            System.out.print(x + " ");

        sc.close();
    }
}