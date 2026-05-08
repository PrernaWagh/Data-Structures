// You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

// Return the sum of all subarray ranges of nums.

import java.util.*;

public class SumOfSubarrayRanges {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long total = 0;
        int mod = (int)1e9 + 7;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {

            // Treat out-of-bound as smallest element
            while (!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])) {

                int mid = st.pop();

                int leftIndex = st.isEmpty() ? -1 : st.peek();
                int rightIndex = i;

                long left = mid - leftIndex;
                long right = rightIndex - mid;

                total = (total + (left * right % mod) * arr[mid] % mod) % mod;
            }

            st.push(i);
        }

        return (int) total;
    }
}