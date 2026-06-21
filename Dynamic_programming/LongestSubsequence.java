import java.util.Arrays;

class LongestSubSequence {

    int f(int index, int prev_index, int arr[], int n, int dp[][]) {
        if (index == n)
            return 0;

        if (dp[index][prev_index + 1] != -1)
            return dp[index][prev_index + 1];

        int notTake = f(index + 1, prev_index,  arr, n, dp);

        int take = 0;

        if (prev_index == -1 || arr[index] > arr[prev_index]) {
            take = 1 + f(index + 1,index, arr, n, dp);
        }
        return dp[index][prev_index + 1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n][n + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return f(0, -1, nums, n, dp);
    }
}