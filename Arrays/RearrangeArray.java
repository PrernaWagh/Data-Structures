//You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
//You should return the array of nums such that the array follows the given conditions:
//Every consecutive pair of integers have opposite signs.
//For all integers with the same sign, the order in which they were present in nums is preserved.
//The rearranged array begins with a positive integer.
//Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int posIndex=0;
        int negIndex =1 ;
        int nums1[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > 0)
            {
                nums1[posIndex] = nums[i];
                posIndex+=2;
            }
            else{
                nums1[negIndex] = nums[i];
                negIndex+=2;
            }
        }
        return nums1;
    }
}