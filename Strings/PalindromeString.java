import java.util.HashMap;

public class PalindromeString {
    public int longestPalindrome(String s) {
        int result = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        boolean oddFreq = false;
        
        for(char ch : s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int count : map.values())
        {
            if(count % 2 == 0 )
            {
                result += count;
            }
            else{
                result += count - 1;
                oddFreq = true;
            }
        }
        if(oddFreq)
        {
            result++;
        }
        return result;
    }
    public static void main(String s[])
    {
        PalindromeString p1 = new PalindromeString();
        String str = null;
        str = "abccccdd";
        int result = 0;
        result = p1.longestPalindrome(str);
        System.out.println(result);
    }

}
