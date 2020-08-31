from collections import defaultdict
class HashTable(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #initialize a hash table object
        hash_table = defaultdict(int)
        #for each num in list nums
        for num in nums:
            #add value to key if duplicate is met
            hash_table[num] += 1
        #for each key in hash table
        for key in hash_table:
            #if key has 1 value
            if hash_table[key] == 1:
                #return key
                return key
            
