import java.util.Arrays;
public class LongestCommonPrefix {
    String findCommonPrefix(String[] str)
    {
        Arrays.sort(str);
        String first = str[0];
        String last =str[str.length - 1];
        String ans = "";
        for(int i = 0;i<first.length();i++)
        {
            if(first.charAt(i) != last.charAt(i))
            {
                break;
            }
            else{
                ans += first.charAt(i);
            }
        }
        return ans;
    }
    public static void main(String s[])
    {
        LongestCommonPrefix s1 = new LongestCommonPrefix();
        String str[] = {"club","clutch","clap","city","cluster"};
        String result = s1.findCommonPrefix(str);
        System.out.println("Longest common prefix is : "+result);
    }
}
