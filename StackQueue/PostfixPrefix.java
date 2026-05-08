
import java.util.Stack;

public class PostfixPrefix {

    String prefix_infix(String str) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while(i < str.length()){

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

                String ans =  ch +t2+ t1;
                st.push(ans);
            }
            i++;
        }

        if (st.size() != 1) {
            System.out.println("Invalid Expression at end");
            return "";
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String str = "AB-DE+F*/";
        PostfixPrefix obj1 = new PostfixPrefix();
        String result = null;

        result = obj1.prefix_infix(str);
        System.out.println("Postfix-Prefix expression is : " + result);
    }
}
