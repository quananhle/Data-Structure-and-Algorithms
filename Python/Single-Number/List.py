class List(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        no_duplicate_list = []
        #for each element in nums
        for num in nums:
          #if element is met the first time and no same element known before
            if num not in no_duplicate_list:
              #append element to the list no_duplicate_list
              no_duplicate_list.append(num)
            else:
              #otherwise, remove the element from the list no_duplicate_list
              no_duplicate_list.remove(num)
        #return the only element in the list
        return no_duplicate_list[0] #no_duplicate_list.pop()
