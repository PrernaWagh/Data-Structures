//program to check whether given two strings are isomorphic or not.

import java.util.HashMap;

public class IsomorphicString {
    boolean isIsomorphic(String s,String t)
    {
        //brute force approach
        int n = s.length();
        int m = t.length();

        if(n != m) return false;
        for(int i = 0;i < n;i++) 
        {
            for(int j = i+1;j< m;j++)   
            {
                if(s.charAt(i) == s.charAt(j) && t.charAt(i) != t.charAt(j))
                    return false;
                if(s.charAt(i) != s.charAt(j) && t.charAt(i) == t.charAt(j))
                    return false;
            }
        }
        return true;
    }

    boolean isIsomorphic2(String s,String t)
    {
        //optimal approach using hashmap
        HashMap<Character,Character> mapS = new HashMap<>();
        HashMap<Character,Character> mapT = new HashMap<>();

        if(s.length() != t.length()) return false;
        for(int i = 0;i<s.length();i++)
        {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(mapS.containsKey(cs) && mapS.get(cs) != ct) return false;
            if(mapT.containsKey(ct) && mapT.get(ct) != cs) return false;

            mapS.put(cs,ct);
            mapT.put(ct,cs);
        }

        return true;
    }
    public static void main(String s[])
    {
        IsomorphicString obj1 = new IsomorphicString();
        String s1 = "paper";
        String s2 = "title";
        if(obj1.isIsomorphic2(s1, s2))
        {
            System.out.println("Strings are isomorphic");
        }
        else{
            System.out.println("Strings are not isomorphic");
        }
    }

}
