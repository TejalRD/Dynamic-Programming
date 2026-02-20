//dp[i][j]=dp[i−1][j]+dp[i][j−1]

class Solution {
    public int uniquePaths(int m, int n) 
    {
        int[] dp = new int[n];

        //first row, all 1s, can only move right
        for(int j =0;j<n;j++)
        {
            dp[j]=1;
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[j]=dp[j]+dp[j-1]; //dp[j] is from above, dp[j-1] is from left.
            }
        }
    return dp[n-1];

    }
}