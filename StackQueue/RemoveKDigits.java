// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
import java.util.Stack;
class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0;i < num.length();i++)
        {
            while(!st.isEmpty() && k > 0 && (st.peek() - '0') > (num.charAt(i) - '0'))
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k > 0)
        {
            st.pop();
            k--;
        }
        if(st.isEmpty())
            return "0";

        while(!st.isEmpty())
        {
            res.append(st.pop());
        }
        res.reverse();
        while(res.length() > 0 && res.charAt(0) == '0')
        {
            res.deleteCharAt(0);
        }

        return res.length()== 0 ? "0" : res.toString();
        
    }
}