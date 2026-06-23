class Knapsack {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int dp[][] = new int[n][W +1];
        for(int i = wt[0];i<=W;i++)
        {
           dp[0][i] = val[0];
        }
        for(int ind=1;ind < n;ind++)
        {
            for(int j =0;j<=W;j++)
            {
                int notTake = 0 + dp[ind - 1][j];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= j)
                {
                    take = val[ind] + dp[ind - 1][j-wt[ind]];
                }
                dp[ind][j] = Math.max(take,notTake);
            }
        }
        return dp[n-1][W];
    }
}
