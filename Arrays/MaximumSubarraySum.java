//Maximum subarray sum

public class MaximumSubarraySum {

    int max_sum(int arr[], int n) {
        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
             if (sum == 0) {
                start = i;
            }
            sum += arr[i];
           
            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        if (max < 0) {
            max = 0;
        }
        return max;
    }

    public static void main(String s[]) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, 2, -3};
        MaximumSubarraySum ms = new MaximumSubarraySum();
        System.err.println("Maximum sum is :"+ms.max_sum(arr, arr.length));
    }
}
