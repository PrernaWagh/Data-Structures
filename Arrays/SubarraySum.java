//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

import java.util.HashMap;
class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum =0;
        map.put(0, 1);
        int cnt=0;
        for(int i=0;i<nums.length;i++)   
        {
            sum +=nums[i];
            if(map.containsKey(sum-k))
            {
                cnt += map.get(sum -k);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }

    public static void main(String s[]) {

	SubarraySum s1 = new SubarraySum();
	
        int arr[] = {1,2,3,-3,1,1,1,4,2,-3};
        System.out.println(s1.subarraySum(arr,3));
    }
}
