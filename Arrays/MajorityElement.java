class MajorityElement {
    public int majorityElement(int[] nums) {
        int cnt =0;
        int ele = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(cnt == 0)
            {
                cnt =1;
                ele = nums[i];
            }
            else if(ele == nums[i])
            {
                cnt++;
            }
            else{
                cnt--;
            }
        }
        cnt =0;
        for(int i =0;i<n;i++)
        {
            if(ele == nums[i]) cnt++;
        }
        if(cnt > (int)(n/2))
        {
            return ele;
        }
        return 0;
    }
}