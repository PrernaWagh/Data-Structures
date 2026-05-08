
import java.util.Stack;

public class PrefixPostfix {

    String prefix_infix(String str) {
        Stack<String> st = new Stack<>();
        int i = str.length() - 1;
        while(i >= 0){

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

                String ans =  t1 + t2 + ch;
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
        String str = "AB-DE+F*/";
        PrefixPostfix obj1 = new PrefixPostfix();
        String result = null;

        result = obj1.prefix_infix(str);
        System.out.println("Prefix-Postfix expression is : " + result);
    }
}
