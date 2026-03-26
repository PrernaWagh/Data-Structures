public class ValidParenthesis{
    boolean isValidParenthesis(String str) 
    {
        int min = 0;
        int max = 0;
        for(int i=0;i<str.length();i++)  
        {
            if(str.charAt(i) == '(')
            {
                min = min + 1;
                max = max + 1;
            }
            else if(str.charAt(i) == ')')
            {
                min = min - 1;
                max = max - 1;
            }
            else{
                min = min -1;
                max = max + 1;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return (min == 0);
    }
    public static void main(String s[])
    {
        String str = "(**(";
        ValidParenthesis v1 = new ValidParenthesis();
        if(v1.isValidParenthesis(str))
        {
            System.out.println("This string has valid parenthesis");
        }
        else{
            System.out.println("This string has no valid parenthesis");
        }
    }
}