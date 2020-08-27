class SwapSolution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        cnt = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                if cnt != i:
                    nums[cnt], nums[i] = nums[i], nums[cnt]
                cnt += 1
