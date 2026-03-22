//Find largest odd number in a string

public class LargestOddNumber{
    String largestOdd(String s)
    {
        String max = "";
        int n = s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++)
            {
                String substr = s.substring(i,j+1);

                char last = substr.charAt(substr.length() - 1);
                if((last - '0')%2 != 0)
                {
                    if(max.equals("") || max.length() == substr.length() && substr.compareTo(max) > 0 || substr.length() > max.length())
                    {
                        max = substr;
                    }
                }
            }
        }
        return max;
    }
    String largestOdd2(String s)
    {
        for(int i = s.length() - 1;i >= 0;i--)
        {
            if((s.charAt(i) - '0') % 2 != 0)
            {
                return s.substring(0,i+1);
            }
        }
        return "";
    }
    public static void main(String s[])
    {
        LargestOddNumber obj = new LargestOddNumber();
        String str = "251478890";
        String result = obj.largestOdd2(str);
        System.out.println(result);
    }
}

// output:- 25147889