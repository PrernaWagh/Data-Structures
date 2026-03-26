import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis{
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder st = new StringBuilder();

        backtrack(n, 0, 0, st, res);
        return res;
    }
    void backtrack(int n, int open, int close, StringBuilder st, List<String> res) {
        if (open == n && close == n) {
            res.add(st.toString());
            return;
        }
        if (open < n) {
            st.append('(');
            backtrack(n, open + 1, close, st, res);
            st.deleteCharAt(st.length() - 1); // pop
        }
        if (close < open) {
            st.append(')');
            backtrack(n, open, close + 1, st, res);
            st.deleteCharAt(st.length() - 1); // pop
        }
    }
    public static void main(String s)
    {
        GenerateParenthesis obj = new GenerateParenthesis();
        int n = 3;
        List<String> result = obj.generateParenthesis(n);
        System.out.println(result);
    }
}