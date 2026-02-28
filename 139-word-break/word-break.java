class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> wordset = new HashSet<>(wordDict);
        int maxLen = 0;
        for(String w: wordDict){
            maxLen=Math.max(maxLen,w.length());
        }
        boolean[]dp = new boolean[n+1];
        dp[0]=true;

        for(int i=1;i<=n;i++)
        {
            int start= Math.max(0, i-maxLen);
            for(int j=start;j<i;j++)
            {
                if(!dp[j]) continue;
                String piece = s.substring(j,i);
                
                if(wordset.contains(piece))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}