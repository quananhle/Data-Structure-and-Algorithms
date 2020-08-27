class HeapSolution:
    def lastStoneWeight(self, stones)

        # Make all the stones negative. We want to do this *in place*, to keep the space complexity of this algorithm at O(1)
        for i in range(len(stones)):
            stones[i] *= -1

        # Heapify all the stones.
        heapq.heapify(stones)

        # While there is more than one stone left, remove the two largest, smash them together, 
        # and insert the result back into the heap if it is non-zero.
        while len(stones) > 1:
            heaviest_1 = heapq.heappop(stones)
            heaviest_2 = heapq.heappop(stones)
            if heaviest_1 != heaviest_2:
                heapq.heappush(stones, heaviest_1 - heaviest_2)

        # Check if there is a stone left to return. Convert it back to positive.
        return -heapq.heappop(stones) if stones else 0
