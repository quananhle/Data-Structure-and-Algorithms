class ShortSolution:
    def lastStoneWeight(self, stones):
        while len(stones) != 1:
            stones = sorted(stones)
            last = stones.pop()
            stones[len(stones)-1] = last - stones[len(stones)-1]
        return stones[0]
