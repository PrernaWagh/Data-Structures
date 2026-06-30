class TrieNode {
    TrieNode links[] = new TrieNode[26];
    int cntEndsWith = 0;
    int cntPrefix = 0;

    public TrieNode() {

    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, TrieNode TrieNode) {
        links[ch - 'a'] = TrieNode;
    }

    void incrementEnd() {
        cntEndsWith++;
    }

    void incrementPrefix() {
        cntPrefix++;
    }

    void deleteEnd() {
        cntEndsWith--;
    }

    void reducePrefix() {
        cntPrefix--;
    }

    int getEnd() {
        return cntEndsWith;
    }

    int getPrefix() {
        return cntPrefix;
    }
}

public class Trie2 {
    private static TrieNode root;

    Trie2() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            // check whether that node exists or not
            if (!node.containsKey(word.charAt(i))) {
                // if not exists then put it and point to its reference try
                node.put(word.charAt(i), new TrieNode());

            }
            // moves to reference try
            node = node.get(word.charAt(i));
            node.incrementPrefix();
        }
        node.incrementEnd();
    }

    int countWordsEqualTo(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }

        return node.getEnd();
    }

    int countWordsStartsWith(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.getPrefix();
    }

    void erase(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }
            else{
                return;
            }
        }

        node.deleteEnd();
    }
}
