
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMax{
    List<Integer> slidingWindowMax(int nums[],int k)
    {
        //TC - O(N-k)*K
        //SC - O(N-K)
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i = 0;i < n-k;i++)
        {
            int max = nums[i];
            for(int j = i;j< i+k-1;j++)
            {
                max = Math.max(max,nums[j]);
            }
            list.add(max);
        }
        return list;
    }
}