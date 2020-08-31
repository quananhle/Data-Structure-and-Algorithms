class Set:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #initialize a set
        num_set = set()
        #for each element in list nums
        for num in nums:
            #if duplicate/second element of the same num found
            if num in num_set:
                #remove from num_set
                num_set.remove(num)
            else:
                #otherwise, add element to num_set
                num_set.add(num)
        #return the only element left or the first element in num_set
        return num_set.pop()
