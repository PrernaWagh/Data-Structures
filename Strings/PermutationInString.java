import java.util.Arrays;

public class PermutationInString{
    
    public boolean checkInclusion2(String s1, String s2) {
        //better approach using sorting and comparing
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;

        char sorteds1[] = s1.toCharArray();
        Arrays.sort(sorteds1);

        for(int i =0 ;i<m-n;i++)
        {
            String temp = s2.substring(i,i+n);
            char sortedTemp[]  = temp.toCharArray();
            Arrays.sort(sortedTemp);

            if(Arrays.equals(sortedTemp,sorteds1))
            {
                return true;
            }   
        }
        return false;
    }
    static boolean checkInclusion3(String s1,String s2)
    {
        //optimal solution using sliding window
        int n = s1.length();
        int m = s2.length();
        int s1_freq[] = new int[26];
        int s2_freq[] = new int[26];
       
        if(n > m) return false;
       
        for(int i=0;i<n;i++)
        {
            s1_freq[s1.charAt(i) - 'a']++;
        }
        int i = 0;
        int j = 0;

        while(j < m)
        {
            s2_freq[s2.charAt(j) - 'a']++;

            if(j-i+1 > n)
            {
                s2_freq[s2.charAt(i)-'a']--;
                i++;
            }

            if(Arrays.equals(s1_freq,s2_freq))
            {
                return true;
            }
            j++;
        }
        
        return false;
    }
    public static void main(String s[])
    {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = checkInclusion3(s1,s2);
        System.out.println(result);
    }
}