/* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
 it reads the same forward and backward. 
 Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
*/
public class ValidPalindrome {
    boolean isAlphaNum(char ch)
    {
        if(ch >='0' && ch <= '9' || Character.toLowerCase(ch) >= 'a' &&Character.toLowerCase(ch) <= 'z')
        {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
       int st =0;
       int end = s.length() - 1;
       while(st < end)
       {
            if(!isAlphaNum(s.charAt(st)))
            {
                st++;
                continue;
            }
            if(!isAlphaNum(s.charAt(end)))
            {
                end --;
                continue;
            }
            if(Character.toLowerCase(s.charAt(st)) != 
               Character.toLowerCase(s.charAt(end)))
            {
                return false; // mismatch
            }

            st++;
            end--;
       }
       return true;

    }
    public static void main(String s[]) {
        ValidPalindrome  s1 = new ValidPalindrome();
        String str = "A man, a plan, a canal: Panama";
        if(s1.isPalindrome(str))
        {
            System.out.println("String is valid palindrome");
        }
        else{
            System.out.println("String is not valid palindrome");
        }
    }
}
