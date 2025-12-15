class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        pos = defaultdict(list)
        for i, ch in enumerate(source):
            pos[ch].append(i)
        
        for ch in set(target):
            if ch not in pos:
                return -1
        ans = 1
        cur = -1

        for ch in target:
            lst = pos[ch]
            k = bisect_right(lst,cur)
            if k == len(lst):
                ans +=1
                cur = lst[0]
            else:
                cur = lst[k]
        return ans