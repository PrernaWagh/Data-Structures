
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermutation {
        void getPermutations(String str, int index, List<List<Character>> ans) {
            int n = str.length();
            if (index == n) {
                List<Character> temp = new ArrayList<>();
                for (char s : str.toCharArray()) {
                    temp.add(s);
                }
                ans.add(temp);
                return;
            }
            for (int i = index; i < n; i++) {
                str = swap(str, index, i);
                getPermutations(str, index + 1, ans);
                str = swap(str, index, i);
            }
        }

        String swap(String str, int i, int j) {
            char arr[] = str.toCharArray();
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            return new String(arr);
        }
        public List<List<Character>> permute(String str) {
            List<List<Character>> ans = new ArrayList<>();
            getPermutations(str, 0, ans);
            return ans;
        }

    public static void main(String s[]) {
        StringPermutation s1 = new StringPermutation();
        String input = null;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();

        List<List<Character>> ans = s1.permute(input);
        System.out.println(ans);
    }
}
