/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), 
return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

*/

import java.util.Stack;

public class NextGreater2 {
     public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 2*n -1;i>=0;i--)
        {
            while(st.size() > 0 && nums[st.peek()] <= nums[i % n])
            {
                st.pop();
            }
            if(st.empty())
            {
                ans[i % n] = -1;
            }
            else{
                ans[i % n] = nums[st.peek()];
            }

            st.push(i % n);
        }
        return ans;
    }
}
