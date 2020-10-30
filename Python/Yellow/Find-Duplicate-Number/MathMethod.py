class MathMethod(object):
    def findDuplicate(self, nums):
    """
    sum(nums): find the sum of all values in nums
    sum(set(nums)): find the sum of all distinct values in nums as set contains no duplicate elements
    len(nums): number of elements in the list
    len(set(nums)): number of elements in the set
    """
    #sum(nums) - sum(set(nums)) yields the total value of the duplicate element
    #len(nums) - len(set(nums)) yields the times the element appears more than once in the list
		return (sum(nums) - sum(set(nums))) / (len(nums) - len(set(nums)))
