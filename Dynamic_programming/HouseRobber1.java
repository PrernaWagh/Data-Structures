
import java.util.Arrays;

class HouseRobber1 {
    // recursive solution
    int f(int index, int nums[]) {
        if (index == 0)
            return nums[index];
        if (index < 1)
            return 0;

        int pick = nums[index] + f(index - 2, nums);
        int notpick = 0 + f(index - 1, nums);

        return Math.max(pick, notpick);
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        return f(n - 1, nums);
    }

    // memoization
    int f2(int index, int nums[], int dp[]) {
        if (index == 0)
            return nums[index];
        if (index < 1)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int pick = nums[index] + f(index - 2, nums);
        int notpick = 0 + f(index - 1, nums);

        return dp[index] = Math.max(pick, notpick);
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return f2(n - 1, nums, dp);
    }

    // tabulation
    int f3(int nums[], int dp[]) {
         int n = nums.length;
        dp[0] = nums[0];
        int neg = 0;
        for(int i=1;i < n;i++)
        {
            int pick = nums[i];
            if(i > 1) pick += dp[i - 2];
            int notpick = 0 + dp[i-1];
            
            dp[i] = Math.max(pick,notpick);
        }
        return dp[n-1];
    }

    public int rob3(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return f3(nums, dp);
    }

    // space optimized solution
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += prev2;
            int notpick = 0 + prev;
            int curr = Math.max(pick, notpick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}