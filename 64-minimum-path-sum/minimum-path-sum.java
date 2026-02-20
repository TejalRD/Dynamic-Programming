//dp[i][j]=grid[i][j]+min(dp[i−1][j], dp[i][j−1])

class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        int[]dp= new int[n];

        dp[0] = grid[0][0];

        //fill first row
        for(int j=1;j<n;j++)
        {
            dp[j] = dp[j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++)
        {
            //first column only from top
            dp[0]=dp[0]+grid[i][0];
            for(int j=1;j<n;j++)
            {
                dp[j]=grid[i][j]+Math.min(dp[j],dp[j-1]);
                // dp[j]   = from top (previous row, same column)
                // dp[j-1] = from left (current row, previous column)
            }
        }
        return dp[n-1];
    }
}