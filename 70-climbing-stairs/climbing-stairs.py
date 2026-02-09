class Solution:
    def climbStairs(self, n: int) -> int:
        if n <=2:
            return n
        
        prev1=2 #Number of ways to reach the previous step (i−1)
        prev2=1 #Number of ways to reach the step before previous (i−2) 

        for _ in range(3,n+1):
            current = prev1+prev2
            prev2 = prev1
            prev1 = current
        return prev1
