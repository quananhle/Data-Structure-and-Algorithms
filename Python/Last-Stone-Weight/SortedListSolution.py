class Solution(object):
    def lastStoneWeight(self, stones):
        """
        :type stones: List[int]
        :rtype: int
        """
        #special case handler
        #list is empty
        if not stones:
            return 0
        elif len(stones) == 1:
            return stones[0]
        else:
            while len(stones) > 1:
                stones.sort()
                heaviest_1 = stones.pop()
                heaviest_2 = stones.pop()
                if heaviest_1 != heaviest_2:
                    bisect.insort(stones, heaviest_1 - heaviest_2)
            return stones[0] if stones else 0
