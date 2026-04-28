//sum of subarray minimums

import java.util.Stack;

public class SumOfSubarrayMin {
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

    public int sumSubarrayMins(int[] arr) {
        int mod = (int)1e9 + 7;
        int n = arr.length;

        int[] nse = findNse(arr);
        int[] pse = findPse(arr);

        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            total = (total + (left * right % mod) * arr[i] % mod) % mod;
        }

        return (int) total;
    }
    //optimize approach
    public int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        long total = 0;
        Stack<Integer> st = new Stack<>();
        int mid = 0;
        int leftIndex =0 ;
        int rightIndex = 0;
        long left = 0;
        long right = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])) {

                 mid = st.pop();

               leftIndex = st.isEmpty() ? -1 : st.peek();
                rightIndex = i;

                left = mid - leftIndex;
                right = rightIndex - mid;

                total += left * right * arr[mid];
            }
            st.push(i);
        }

        return (int)total;
    }
}
