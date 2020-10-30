class Set(object):
    def findDuplicate(self, nums):
        num_set = set()
        for num in nums:
            if num in num_set:
                return num
            num_set.add(num)
