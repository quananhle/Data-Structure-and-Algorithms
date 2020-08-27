class ShortSolution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        #loop backward 1 step at a time
        for i in range(len(nums)-1,-1,-1):
            if nums[i] == 0:
                del nums[i]
                nums.append(0)
