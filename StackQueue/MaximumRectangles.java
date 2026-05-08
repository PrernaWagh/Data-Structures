// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

import java.util.Stack;

class MaximumRectangles {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        int ele = 0;
        int nse = 0;
        int pse = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                ele = heights[st.peek()];
                st.pop();
                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();

                //area
                maxArea = Math.max(ele * (nse - pse - 1), maxArea);
            }
            st.push(i);
        }

        //if elements remaining in stack
        while (!st.isEmpty()) {
            nse = n;
            ele = heights[st.peek()];
            st.pop();
            pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea, ele * (nse - pse - 1));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int heights[] = new int[matrix[0].length];
        int maxArea = 0;
        int largest = 0;
        for(int i = 0;i < matrix.length;i++)
        {
            for(int j = 0;j < matrix[i].length;j++)
            {
                int val = matrix[i][j]- '0';
                if(val == 0)
                {
                    heights[j] = 0;
                }
                else{
                    heights[j] += val;
                }
            }
            maxArea = largestRectangleArea(heights);
            if(largest < maxArea)
            {
                largest = maxArea;
            }
        }
        return largest;
    }
}