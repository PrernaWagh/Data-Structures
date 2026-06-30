class TrieNode1{
    TrieNode1 links[] = new TrieNode1[26];
    boolean flag = false;

    public TrieNode1()
    {
        
    }
    boolean containsKey(char ch)
    {
        return (links[ch - 'a'] != null);
    }
     TrieNode1 get(char ch)
    {
        return links[ch - 'a'];
    }
    void put(char ch,TrieNode1 node)  
    {
        links[ch - 'a'] = node;
    }
}

public class CountDistinctSubstring {
    int countDistinctSubstrings(String s)
    {
        int cnt = 0;
        TrieNode1 root = new TrieNode1();
        for(int i=0;i<s.length();i++)
        {
            TrieNode1 TrieNode1 = root;
            for(int j=i;j<s.length();j++)
            {
                if(!TrieNode1.containsKey(s.charAt(i)))
                {
                    cnt++;
                    TrieNode1.put(s.charAt(j), TrieNode1);
                }
                TrieNode1 = TrieNode1.get(s.charAt(j));
            }
        }
        return cnt + 1;
    }
}
