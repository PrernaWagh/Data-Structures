
import java.util.Stack;

public class PostfixInfix {

    String postfix_infix(String str) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(str.charAt(i));

            if (Character.isLetterOrDigit(ch.charAt(0))) {
                st.push(ch);
            } else {
                if (st.size() < 2) {
                    System.out.println("Invalid Expression");
                    return "";
                }

                String t1 = st.pop();
                String t2 = st.pop();

                String ans = "(" + t2 + ch + t1 + ")";
                st.push(ans);
            }
        }

        if (st.size() != 1) {
            System.out.println("Invalid Expression at end");
            return "";
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String str = "AB-DE+F*/";
        PostfixInfix obj1 = new PostfixInfix();
        String result = null;

        result = obj1.postfix_infix(str);
        System.out.println("Postfix-Infix expression is : " + result);
    }
}
