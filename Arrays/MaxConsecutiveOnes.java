//Given a binary array nums, return the maximum number of consecutive 1s in the array.

//A binary array is an array that contains only 0s and 1s.
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         int max=0,cnt=0;
         int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] ==  1)
            {
                cnt++;
                max = Math.max(max,cnt);
            }
            else{
                cnt =0;
            }
        }
        return max;
    }
}

// input array = int arr[] = {1,1,0,1,1,1,1,1,0,1,1};