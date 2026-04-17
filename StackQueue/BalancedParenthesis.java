//check whether the given parenthesis string is balanced or not, every opening bracket has its respective closing bracket in same order

import java.util.Stack;

public class BalancedParenthesis {

    boolean checkBalanced(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                st.push(str.charAt(i));
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char ch = st.peek();
                st.pop();
                if ((str.charAt(i) == ')' && ch == '(') || (str.charAt(i) == '}' && ch == '{') || (str.charAt(i) == ']' && ch == '[')) {

                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()[{}()]";
        BalancedParenthesis b1 = new BalancedParenthesis();
        if (b1.checkBalanced(str)) {
            System.out.println("Parenthesis are balanced");
        } else {
            System.out.println("Parenthesis are not balanced");
        }
    }
}
