public class MaxProductSubarray {
    int maxProductSubarray(int[] arr)
    {
               
         int n = arr.length;
        int prefix =1;
        int suffix =1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(prefix == 0 ) prefix =1;
            if(suffix == 0) suffix =1;
            prefix = prefix* arr[i];
            suffix = suffix * arr[n-i-1];

            max = Math.max(max,Math.max(prefix,suffix));
        }   
        return max;
    }
     public static void main(String s[])
    {
        MaxProductSubarray m1 = new MaxProductSubarray();
        int arr[] = {-2,3,4,-1,0,-2,3,1,4,0,4,6,-1,4};
        System.out.println("Max subarray product : "+m1.maxProductSubarray(arr));
    }
}
