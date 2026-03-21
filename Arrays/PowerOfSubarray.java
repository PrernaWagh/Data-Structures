// You are given an array of integers nums of length n and a positive integer k.
// The power of an array is defined as:
// Its maximum element if all of its elements are consecutive and sorted in ascending order.
// -1 otherwise.
import java.util.Arrays;
class PowerOfSubarray {
    public int[] resultsArray(int[] nums, int k) {
        //using sliding window
        int n = nums.length;
        int result[] = new int[n-k+1];
        Arrays.fill(result,-1);
        int count = 1;
        for(int i=1;i<k;i++)
        {
            if(nums[i] == nums[i-1] + 1)
            {
                count++;
            }
            else{
                count = 1;
            }
        }
        if(count == k)
        {
            result[0] = nums[k-1];
        }
        int i = 1;
        int j = k;
        while(j < n)
        {
            if(nums[j] == nums[j-1] + 1)
            {
                count++;
            }
            else{
                count = 1 ;
            }
            if(count >= k)
            {
                result[i] = nums[j];
            }
            i++;
            j++;
        }
        return result;
    }
    public static void main(String s[])
    {
        PowerOfSubarray obj = new PowerOfSubarray();
        int arr[] = {1,2,3,4,3,2,5};
        int result[] = obj.resultsArray(arr,3);
        for(int i=0;i<result.length;i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}