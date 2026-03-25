
import java.util.HashMap;

//find the longest substring without repeating characters

public class LongestSubstr {
    int longest_substr(String str)
    {
        int maxlen = 0;
        for(int i = 0;i < str.length();i++)
        {
            int hashArr[] = new int[256];
            int len =0;
            for(int j = i;j < str.length();j++)
            {
                if(hashArr[str.charAt(j)] == 1)
                {
                    break;
                }
                else{
                    len = j - i + 1;
                    System.out.println("Length is : "+len+" "+j+" "+i);
                    maxlen = Math.max(len,maxlen);
                    hashArr[str.charAt(j)] =  1;
                }
            }
        }

        return maxlen;
    }
    String longest_substr2(String str)
    {
        //optimal approach using hashmap and in O(N) time
       HashMap<Character,Integer> map = new HashMap<>();
       int left = 0;
       int right = 0;
       int maxlen = 0;
       int n = str.length();
       int startIndex = 0;
       while (right < n) {
            if(map.containsKey(str.charAt(right)))
            {
                if(map.get(str.charAt(right)) >= left)
                {
                    left = map.get(str.charAt(right)) + 1;
                    
                }
            }
            int len = right - left + 1;
            maxlen = Math.max(len,maxlen);
            startIndex = left;
            map.put(str.charAt(right),right);
            right++;
       }
       return str.substring(startIndex ,startIndex + maxlen);
    }
    public static void main(String s[])
    {
        LongestSubstr s1 = new LongestSubstr();
        String str = "cadbzabcdef";
       String result = s1.longest_substr2(str);
        System.out.println(result);
    }
}
