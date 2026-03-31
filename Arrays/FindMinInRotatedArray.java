//minimum in rotated sorted array
class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n -1 ;
        int mid ;
        int ans = Integer.MAX_VALUE;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(nums[low] <= nums[high])
            {
                ans = Math.min(ans,nums[low]);
                break;
            }
            if(nums[low] <= nums[mid])
            {
                ans = nums[low];
                low = mid + 1;
            }
            else{
                ans = Math.min(ans,nums[mid]);
                high = mid -1;
            }
        }
        return ans;
    }
}