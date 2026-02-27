//Return length of longest subarray whose sum is equal to k.

import java.util.HashMap;
class LongestSubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum =0;
        int maxlen=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++)   
        {
            sum +=nums[i];
	    if(sum == k)
	    {
		maxlen = Math.max(maxlen.i+1);
	    }
            if(map.containsKey(sum-k))
            {
               int len = i-map.get(sum-k);
		maxlen = Math.max(maxlen,len);
            }
            if(!map.containsKey(sum))
	    {
		map.put(sum,i);
	    }
        }
        return maxlen;
    }

    public static void main(String s[]) {

	SubarraySum s1 = new SubarraySum();
	
        int arr[] = {1,2,3,1,1,1,1,4,2,3};
        System.out.println(s1.subarraySum(arr,3));
    }
}
