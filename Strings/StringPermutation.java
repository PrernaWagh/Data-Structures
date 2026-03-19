//find all the permuations of given string 


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermutation {
        void getPermutations(String str, int index, List<String> ans) {
            int n = str.length();
            if (index == n) {
                ans.add(str);
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
        public List<String> permute(String str) {
            List<String> ans = new ArrayList<>();
            getPermutations(str, 0, ans);
            return ans;
        }

    public static void main(String s[]) {
        StringPermutation s1 = new StringPermutation();
        String input = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string : ");
        input = sc.nextLine();

        List<String> ans = s1.permute(input);
        System.out.println("Permuations of string are : ");
        System.out.println(ans);
    }
}

//output:-
// Enter a string : 
// abc
// Permuations of string are : 
// [abc, acb, bac, bca, cba, cab]
