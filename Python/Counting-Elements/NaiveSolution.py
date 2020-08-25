class NaiveSolution(object):
    def countElements(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        cnt = 0
        #special case handler
        #if list is empty: len(arr) == 0
        if not arr:
            return 0
        #if list has only 1 element
        elif len(arr) == 1:
            return arr[0]
        #otherwise
        else:
            for i in sorted(arr):
                if i+1 in arr:
                    cnt += 1
        return cnt
        
