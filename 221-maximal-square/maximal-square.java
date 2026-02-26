class Solution {
    public int maximalSquare(char[][] matrix) 
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prev= new int[n+1]; //dp for prev row
        int maxSide =0;

        for(int r=1; r<=m;r++)
        {
            int[] curr = new int[n+1];
            for(int c=1;c<=n;c++)
            {
                if(matrix[r-1][c-1]=='1'){
                    curr[c]=1+Math.min(prev[c],Math.min(curr[c-1], prev[c-1]));
                    maxSide = Math.max(maxSide,curr[c]);
                }
            }
            prev=curr;
        }
        return maxSide*maxSide;
        
    }
}