class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
#         a = 0
#         for i in nums:
#             a ^= i
#         return a
          return reduce(lambda x, y: x ^ y, nums)
