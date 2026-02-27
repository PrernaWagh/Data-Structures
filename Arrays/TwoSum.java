class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int a = nums[i];
            int next = target - a;
            if(map.containsKey(next))
            {
                return new int[]{map.get(next),i};
            }
            map.put(a,i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String s[])
    {
	 TwoSum t1 = new TwoSum();
        int arr[] = {2,7,5,8,11};
        System.out.println(t1.twoSum(arr,14));
    }
}