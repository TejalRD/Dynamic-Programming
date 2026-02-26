class Solution {
    public int minFallingPathSum(int[][] matrix) 
    {
        int n=matrix.length;
        int []prev = new int[n];

        //base- first row
        for(int c=0; c<n;c++)
        {
            prev[c]=matrix[0][c];
        }
        //build row by row
        for(int r=1; r<n; r++)
        {
            int []curr=new int[n];
            for(int c=0;c<n;c++)
            {
                int best = prev[c];
                if(c-1>=0) {best=Math.min(best,prev[c-1]);}
                if(c+1< n) {best=Math.min(best,prev[c+1]);}
                curr[c]=matrix[r][c]+best;
            }
            prev=curr;
        }
        int ans=prev[0];
        for(int c=1; c<n; c++) ans=Math.min(ans,prev[c]);
        return ans;
    }
}