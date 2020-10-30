class BasicApproach(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        res = collections.defaultdict(int)
        for num in nums:
            res[num] += 1
            if res[num] > 1:
                return num
