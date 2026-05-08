
import java.util.Stack;

public class PrefixInfix {

    String prefix_infix(String str) {
        Stack<String> st = new Stack<>();
        int i = str.length() - 1;
        while(i >=0){
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

                String ans = "(" + t1 + ch + t2 + ")";
                st.push(ans);
            }
            i--;
        }

        if (st.size() != 1) {
            System.out.println("Invalid Expression at end");
            return "";
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String str = "*+PQ-MN";
        PrefixInfix obj1 = new PrefixInfix();
        String result = null;

        result = obj1.prefix_infix(str);
        System.out.println("Prefix-Infix expression is : " + result);
    }
}
