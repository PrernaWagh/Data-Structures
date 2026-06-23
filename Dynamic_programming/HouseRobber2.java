class HouseRobber2 {
    private int maxRob(int[] nums, int start, int end){
        int prev2=0;
        int prev1=0;

        for(int i=start;i<=end;i++){
            int take=prev2+nums[i];
            int skip=prev1;

            int curr=Math.max(take,skip);

            prev2=prev1;
            prev1=curr;

        }

        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int n=nums.length;

        return Math.max(maxRob(nums,0,n-2),maxRob(nums,1,n-1));
        
    }
}