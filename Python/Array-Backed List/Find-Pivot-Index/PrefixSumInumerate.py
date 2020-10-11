class PrefixSumInumerate(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left_sum = 0
        list_sum = sum(nums)
        for i, x in enumerate(nums):
            if left_sum == list_sum - left_sum - x:
                return i
            left_sum += x
        return -1
