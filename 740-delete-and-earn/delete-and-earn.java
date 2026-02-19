class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        Map<Integer,Integer> freq = new HashMap<>();
        int maxVal = 0;
        for(int x :nums)
        {
            freq.put(x, freq.getOrDefault(x, 0)+1);
            if(x>maxVal) maxVal=x;
        }
        int prev2=0;
        int prev1=0;

        for(int x=0;x<=maxVal; x++)
        {
            int gain = x*freq.getOrDefault(x,0);
            int curr = Math.max(prev1, prev2+gain);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
        
    }
}