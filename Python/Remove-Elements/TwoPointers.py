class TwoPointers(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        #initialize count
        count = 0
        #loop in range of length of list nums
        for i in range(len(nums)):
            #if element at index i of nums is not the same as val 
            if nums[i] != val:
                #save the element to index count of list starting from 0
                nums[count] = nums[i]
                #iterate count
                count += 1
        return count
