import java.util.Stack;

public class InfixPostfix {
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
    boolean isOperator(char ch)
    {
        if(ch == '^' ||ch=='*'||ch=='/'||ch=='+'||ch=='-')
        {
            return true;
        }
        return false;
    }
    String infix_postfix(String str)
    {
        String postfix = "";
        int n = str.length();
        Stack<Character> st = new Stack<>();    
        
        for(int i = 0;i<n;i++) 
        {
            char ch = str.charAt(i);

            if(Character.isLetterOrDigit(ch))
            {
                postfix += ch;
            }
            else if(ch == '(')
            {
                st.push(ch);
            }
            else if(ch == ')')
            {
                while(!st.empty() && st.peek() != '(')
                {
                    postfix += st.peek();
                    st.pop();
                }
                st.pop();
            }
            else if(isOperator(ch))
            {
                //1.if stack is empty push it onto stack
                if(st.empty()){
                    st.push(ch);
                }
                else if(!st.empty() && priority(ch) > priority(st.peek()))
                {
                    st.push(ch);
                }
                else{
                    while(!st.empty() && priority(ch) <= priority(st.peek()))
                    {
                        postfix += st.peek();
                        st.pop();
                    }
                    st.push(ch);
                }
            }
        }
        //pop remeaining characters
        while(!st.empty())
        {
            postfix += st.pop();
        }

        return postfix;
    }
    public static void main(String[] args) {
        String str = "a+b*c/(d-e)";
        InfixPostfix obj1 = new InfixPostfix();
        String result = null;

        result = obj1.infix_postfix(str);
        System.out.println("Infix-Postfix expression is : "+result);
    }
}
