class Node{
    Node links[] = new Node[26];
    boolean flag = false;

    public Node()
    {
        
    }
    boolean containsKey(char ch)
    {
        return (links[ch - 'a'] != null);
    }
    Node get(char ch)
    {
        return links[ch - 'a'];
    }
    void put(char ch,Node node)  
    {
        links[ch - 'a'] = node;
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd()
    {
        return flag;
    }
}
public class Trie{
    private static Node root; 

    Trie()
    {
        root = new Node();
    }
    void insert(String word)
    {
        //O(length of word))
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            //check whether that node exists or not
            if(!node.containsKey(word.charAt(i)))
            {
                //if not exists then put it and point to its reference try
                node.put(word.charAt(i),new Node());
            }
            // moves to reference try
            node = node.get(word.charAt(i));
        }

        node.setEnd();
    }
    
    boolean search(String word)
    {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i)))
            {
                return false;
            }
            node = node.get(word.charAt(i));
        }

        return (node.isEnd() == true);

    }

    boolean startsWith(String prefix)   
    {
        Node node = root;
        for(int i=0;i<prefix.length();i++)
        {
            if(!node.containsKey(prefix.charAt(i)))
            {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }

        return true;
    }
    
}