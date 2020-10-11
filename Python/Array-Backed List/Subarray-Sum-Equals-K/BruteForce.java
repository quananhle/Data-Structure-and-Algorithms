class BruteForce(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        cnt = 0
        for start in range(len(nums)):
            subList_sum = 0
            for end in range(start, len(nums)):
                subList_sum += nums[end]
                if subList_sum == k:
                    cnt += 1
        return cnt
