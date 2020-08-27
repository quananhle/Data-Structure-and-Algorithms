class Solution(object):
    def lastStoneWeight(self, stones):
        """
        :type stones: List[int]
        :rtype: int
        """
        #helper function
        def remove_largest():
            #locate the index of the element with max value
            heaviest_1_idx = stones.index(max(stones))
            #swap the highest value element with the last element
            stones[heaviest_1_idx], stones[-1] = stones[-1], stones[heaviest_1_idx]
            #pop the element at the last index
            return stones.pop()
        
        #special case handler
        #list is empty
        if not stones:
            return 0
        #list has only 1 element
        elif len(stones) == 1:
            return stones[0]
        else:
            #loop as long as list has no more than 1 element
            while len(stones) > 1:
                #pop the heaviest element in the list
                heaviest_1 = remove_largest()
                #pop the heaviest element in the list
                heaviest_2 = remove_largest()
                #if the weights of two heaviest elements are not the same
                if heaviest_1 - heaviest_2 != 0:
                    #append the new element into the list after the different weight is subtract
                    stones.append(heaviest_1 - heaviest_2)
            #return the only element in the list if the list is not empty; otherwise, return 0
            return stones[0] if stones else 0
        
