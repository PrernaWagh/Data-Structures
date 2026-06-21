//dynamic programming approach
class ClimbingStairs {
    public int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;
        int curr = 0;

        for(int i=2;i<=n;i++)
        {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}