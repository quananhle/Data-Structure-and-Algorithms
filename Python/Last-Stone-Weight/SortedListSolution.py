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
        #list has 1 element
        elif len(stones) == 1:
            return stones[0]
        else:
            #loop until list has no more than 1 element
            while len(stones) > 1:
                #sort the list
                stones.sort()
                #pop the last element, the heaviest stone in the list
                heaviest_1 = stones.pop()
                #pop the last element, the heaviest stone in the new list
                heaviest_2 = stones.pop()
                #if two stones does not weight the same
                if heaviest_1 != heaviest_2:
                    #insert the new stone after its original weight is deducted
                    bisect.insort(stones, heaviest_1 - heaviest_2)
            #return the only element left in the list if the list is not empty, otherwise return 0
            return stones[0] if stones else 0
