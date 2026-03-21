public class StringCompression{
    int compress_string(char arr[])
    {
        int idx = 0;
        for(int i=0;i<arr.length;i++)
        {
            char ch = arr[i];
            int cnt = 0;
            while(i < arr.length && arr[i] == ch) 
            {
                cnt++;
                i++;
            }
            if(cnt == 1) arr[idx++] = ch;
            else{
                arr[idx++] = ch;
                String str = Integer.toString(cnt);
                for(char dig : str.toCharArray())
                {
                    arr[idx++] = dig;
                }
               
            }
            i--;
        }
        return idx;
    }
    public static void main(String s[])
    {
        StringCompression s1 = new StringCompression();
        char arr[] = {'a','a','b','b','c','c','c'};
        int idx = 0;
        idx = s1.compress_string(arr);
        for(int i=0;i<idx;i++ ){
            System.out.println(arr[i] + " ");
        }
    }
}