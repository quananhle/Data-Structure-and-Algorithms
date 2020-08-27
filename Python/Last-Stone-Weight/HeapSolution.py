class HeapSolution:
    def lastStoneWeight(self, stones)
        # make all the stones negative. We want to do this *in place*, to keep the space complexity of this algorithm at O(1)
        for i in range(len(stones)):
            stones[i] *= -1

        # heapify all the stones.
        heapq.heapify(stones)

        # while there is more than one stone left, remove the two largest, smash them together, 
        # and insert the result back into the heap if it is non-zero.
        while len(stones) > 1:
            #remove and return the smallest element from heap
            heaviest_1 = heapq.heappop(stones)
            #remove and return the smallest element from heap
            heaviest_2 = heapq.heappop(stones)
            if heaviest_1 != heaviest_2:
                #push the new element into stones
                heapq.heappush(stones, heaviest_1 - heaviest_2)

        #check if there is a stone left to return. Convert it back to positive.
        return -heapq.heappop(stones) if stones else 0
