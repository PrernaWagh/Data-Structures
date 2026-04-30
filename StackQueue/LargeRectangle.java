// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

import java.util.Stack;

class LargeRectangle {
    //better approach
     int[] findNse(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    int[] findPse(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public int largestRectangleArea(int[] heights) {
        int nse[] = findNse(heights);
        int pse[] = findPse(heights);

        int max = 0;
        for(int i = 0;i<heights.length;i++)
        {
            max = Math.max(max,heights[i] * (nse[i] - pse[i] - 1)); 
        }
        return max;
    }

    //optimized approach

}