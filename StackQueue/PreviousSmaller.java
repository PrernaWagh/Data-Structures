import java.util.Arrays;

public class PreviousSmaller {
    //brute force approach
    int[] previous_smaller(int arr[])
    {
        int nextSmall[] = new int[arr.length];
        Arrays.fill(nextSmall, -1);
        for(int i = 0;i<arr.length;i++)
        {
            for(int j = i -1 ;j>=0;j--)
            {
                if(arr[j] < arr[i])
                {
                    nextSmall[i] = arr[j];
                    break;
                }
                
            }
        }
        return nextSmall;
    }
    public static void main(String s[])
    {
        PreviousSmaller p1 = new PreviousSmaller();
        int input[] = {4,5,2,10,8};
        int output[] = p1.previous_smaller(input);

        for(int e:output)
        {
            System.out.print(e+" ");
        }

    }
}
