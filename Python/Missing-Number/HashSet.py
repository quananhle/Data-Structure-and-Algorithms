class HashSet(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #initialize a set of distinct elements in list nums
        num_set = set(nums)
        #for number in range of [0..n+1] to have space for only 1 missing number
        for number in range(len(nums) + 1):
            #if a number in range is not num_set
            if number not in num_set:
                #return the missing number
                return number
                
