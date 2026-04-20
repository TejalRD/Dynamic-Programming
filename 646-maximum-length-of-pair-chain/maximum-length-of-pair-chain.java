class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> Integer.compare(a[0],b[0]));

        int n= pairs.length;
        int[] dp= new int[n];
        Arrays.fill(dp,1);

        int maxlen=1;

        for(int i=0; i<n;i++)
        {
            for(int j=0; j<i; j++)
            {
                if(pairs[j][1] < pairs[i][0])
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxlen= Math.max(maxlen,dp[i]);
        }
        return maxlen;

    }
}