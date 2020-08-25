class Solution(object):
    def countElements(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        #set is faster than list in finding element inside it
        hash_set = set(arr)
        count = 0
        #for each element x in arr
        for x in arr:
            #finding x+1 in the hash table yields result as elements are unique, duplicates are removed
            if x + 1 in hash_set:
                count += 1
        return count
