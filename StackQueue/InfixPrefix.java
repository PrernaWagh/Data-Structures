import java.util.Stack;

public class InfixPrefix {
    String swapBrackets(String str)
{
    char[] arr = str.toCharArray();

    for(int i = 0; i < arr.length; i++)
    {
        if(arr[i] == '(')
            arr[i] = ')';
        else if(arr[i] == ')')
            arr[i] = '(';
    }

    return new String(arr);
}
    String rev(String str)
    {
        int start = 0;
        int end = str.length() - 1;
        char arr[] = str.toCharArray();
        while(start <= end)
        {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return new String(arr);
    }
     int priority(char op)
    {
        switch(op)
        {
            case '^':return 3;
            case '*':
            case '/':return 2;
            case '+':
            case '-':return 1;
        }
        return 0;
    }
    String infix_prefix(String str)
    {
        int n = str.length();
        str = rev(str);
        str = swapBrackets(str);
        int i = 0;
        String output = "";
        Stack<Character> st = new Stack<>();
        
        while(i < n)
        {
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                output += ch;
            }
            else if(ch == '(')
            {
                st.push(ch);
            }
            else if(ch == ')')
            {
                while(!st.empty() && st.peek() != '(')
                {
                    output += st.pop();
                }
                st.pop();
            }
            else{
                //if operator
                if(ch == '^')
                {
                    while(!st.empty() && priority(ch) <= priority(st.peek()))
                    {
                        output += st.pop();
                    }
                }
                else{
                        while(!st.empty() && priority(ch) < priority(st.peek()))
                        {
                            output += st.pop();
                        }
                    st.push(ch);
                }
            }
            i++;
        }

        while(!st.empty())
        {
            output += st.pop();
        }
        output = rev(output);
        return output;
    }
    public static void main(String[] args) {
        String str = "(A+B)*C-D+F";
        InfixPrefix obj1 = new InfixPrefix();
        String result = null;

        result = obj1.infix_prefix(str);
        System.out.println("Infix-Prefix expression is : "+result);
    }
}
