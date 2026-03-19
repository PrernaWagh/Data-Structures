
//reverse the order of words in a string 

public class ReverseWords {
    public String strRev(String str) 
    { 
        char arr[] = str.toCharArray(); 
        int start = 0; 
        int end = arr.length-1; 
        while(start <= end) 
        { 
            char temp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = temp; 
             
            start++; 
            end--; 
        } 
         
        return new String(arr); 
    }
    public String reverseWords(String s) {
        String ans="";
        String reversed = new StringBuilder(s).reverse().toString();
        String arr[] = reversed.split("\\s+");
      
        for(int i=0;i<arr.length;i++)
        {
            String word = "";
            if(i< arr.length && !arr[i].equals(" "))
            {
                word+=arr[i];
            }
            word = strRev(word);
            if(word.length() > 0)
            {
                ans+= " "+word;
            }
        }
        return ans.trim();
    }
    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        String ans = r.reverseWords("the sky is blue");
        System.out.println(ans);

    }
}