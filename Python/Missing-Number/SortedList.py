class SortedList(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #sort the list
        nums.sort()
        #special cases handler
        #check if the list does not start from 0 or if list is empty
        #[1] -> 0, [1,2] -> 0, [1,2,3,4,5] -> 0
        if nums[0] != 0 or len(nums) == 0:
            #return 0
            return 0
        #check if there is no missing num in the list of consecutive numbers
        #[0,1] -> 2, [0,1,2] -> 3, [0,1,2,3,4,5] -> 6
        elif nums[-1] != len(nums):
            #return the number next to the last index
            return len(nums)
        else:
            #otherwise, the missing number is inside 0..n
            #[0,2,3] -> 1, [0,1,3,4] -> 2
            #start the counter from 1 to the length of the list
            for i in range(1, len(nums)):
                #missing_num starts from i <- 1
                missing_num = nums[i-1] + 1
                if nums[i] != missing_num:
                    return missing_num
