class Solution {
    public int minDistance(String word1, String word2) {
        int m= word1.length();
        int n= word2.length();
        
        int[][]dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)dp[i][0]=i;    //deletes
        for(int j=0;j<=n;j++)dp[0][j]=j;    //inserts

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                char a=word1.charAt(i-1);
                char b=word2.charAt(j-1);

                if(a==b)
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    int insert = dp[i][j-1]+1;
                    int delete = dp[i-1][j]+1;
                    int replace= dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(insert,Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }
}